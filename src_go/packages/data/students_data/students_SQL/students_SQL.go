package data_studentsdata_studentsSQL

import (
	"context"
	"fmt"
	"log"

	"github.com/jackc/pgx/v4"
	"github.com/jackc/pgx/v4/pgxpool"
	_ "github.com/joho/godotenv/autoload"
	"github.com/lib/pq"
	class "sigaa.ufpe/packages/data/class_data"
	student "sigaa.ufpe/packages/data/students_data"
	singleton_db "sigaa.ufpe/packages/utils/singleton"
)

var db *pgxpool.Pool

func IsValidUser(username string, password string) bool {
	db = singleton_db.Refer_DB()
	var storedPassword string
	err := db.QueryRow(context.Background(), "SELECT pswrd FROM students WHERE usr = $1", username).Scan(&storedPassword)
	if err != nil {
		if err == pgx.ErrNoRows {
			fmt.Println("DATABASE RETURNED FALSE")
			return false
		}
		log.Fatalf("Erro ao consultar o banco de dados: %v", err)
	}
	fmt.Println(password, storedPassword)
	return password == storedPassword
}

func InsertUser(username string, password string) {
	db = singleton_db.Refer_DB()
	if !IsValidUser(username, password) {
		db.Exec(context.Background(), "INSERT INTO students (usr, pswrd) VALUES ($1, $2)", username, password)
	}

}

func GetUser(username string) []student.Student {
	db = singleton_db.Refer_DB()
	rows, err := db.Query(context.Background(), "SELECT usr, pswrd, disciplines, deferral, enrolled, historic4 FROM students WHERE usr = $1",username)
	if err != nil{
		log.Fatal("Student_SQL.go: It was not possible to realize the querry")
	}
	defer rows.Close()

	var users []student.Student
	for rows.Next() {
		var user student.Student
		var disciplines pq.StringArray
		err := rows.Scan(&user.User, &user.Password, &disciplines, &user.Deferral, &user.Enrolled, &user.Historic)
		if err != nil{
			fmt.Println(err)
			log.Fatal("Student_SQL.go: Error during row scan")
		}
		user.Disciplines = disciplines
		users = append(users, user)
	}
	return users
}

func GetAllUsers() []student.Student {
	db = singleton_db.Refer_DB()
	rows, err := db.Query(context.Background(), "SELECT usr, pswrd FROM students")
	if err != nil {
		log.Fatal("Student_SQL.go : It was not possible to realize the querry")
	}
	defer rows.Close()

	var users []student.Student
	for rows.Next() {
		var user student.Student
		err := rows.Scan(&user.User, &user.Password)
		if err != nil {
			log.Fatal("Student_SQL.go: Erros during row scan")
		}
		users = append(users, user)
	}

	if err := rows.Err(); err != nil {
		fmt.Println(err)
		log.Fatal("Student_SQL.go: Error during row scan")
	}

	return users
}


func Update_Student_Enrollment(username string, classes []class.Class){
	db = singleton_db.Refer_DB()
	
	query := "Update students SET "

	var class_enrolled pq.StringArray

	query += "disciplines = ARRAY["
	for i, class := range classes{

		fmt.Println(class)
		query += "'" +class.Name +"'"
		if i < len(classes)-1{
			query += ", "
		}

	} 
	query += "] "

	query += ", enrolled = true"

	fmt.Println(class_enrolled)
	query += " WHERE usr ='" +username + "'"
	fmt.Println(query)
	
	_, err := db.Exec(context.Background(), query)
	if err != nil{
		fmt.Println(err)
		log.Fatal("Student_SQL.go: Error during Exec query")
	}

	Insert_Student_Grades(username, classes)

}

func Update_Student_Deferral(username string){
	db = singleton_db.Refer_DB()

	query := "UPDATE students  SET deferral=true , enrolled=false , disciplines=NULL WHERE usr='"+username+"'"
	_, err := db.Exec(context.Background(), query)
	if err != nil{
		fmt.Println(err)
		log.Fatal("student_SQL.go: Error duting UPDATE Query")
	}

}

func Retake_Student_Enrollment(username string){
	db = singleton_db.Refer_DB()

	query := "UPDATE students SET deferral=false, enrolled=false WHERE usr='"+username+"'"
	_, err := db.Exec(context.Background(), query)
	if err != nil{
		fmt.Println(err)
		log.Fatal("student_SQL.go: Error during UPDATE Query")
	}
}

func Insert_Student_Grades(username string, classes []class.Class){
	db = singleton_db.Refer_DB()

	for _, class := range(classes){

		query := "INSERT INTO grades (class, assignment, student, grade) VALUES ('"+class.Name+"',"

		for _, assignment := range(class.Assesment){
			query_2 := ""
			query_2 += "'"+assignment+"','"+ username+"',"+"NULL);"

			_,err := db.Exec(context.Background(), query+query_2)
			if err != nil{
				fmt.Println(query)
				fmt.Println(err)
				log.Fatal("student_SQL.go: Error during Insert into Grades")
			}
		}
	}

}