package login_control

import (
	student "sigaa.ufpe/packages/data/students_data"
	data_studentsdata_studentsSQL "sigaa.ufpe/packages/data/students_data/students_SQL"
)


func IsValidUser(username string, password string) bool {
	return data_studentsdata_studentsSQL.IsValidUser(username, password)
}

func InsertUser(username string, password string){
	data_studentsdata_studentsSQL.InsertUser(username, password)
}

func GetAllUsers() ([]student.Student){
	return data_studentsdata_studentsSQL.GetAllUsers()
}

func GetUser(username string) []student.Student{
	return data_studentsdata_studentsSQL.GetUser(username)
}