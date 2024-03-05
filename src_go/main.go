package main

import (
	_ "github.com/joho/godotenv/autoload"

	"sigaa.ufpe/packages/comunication/login_controller"
	"sigaa.ufpe/packages/comunication/main_menu_controller"
	data_studentsdata_studentsSQL "sigaa.ufpe/packages/data/students_data/students_SQL"
	//data_studentsdata_studentsSQL "sigaa.ufpe/packages/data/students_data/students_SQL"
)

var db = make(map[string]string)

func main() {
	channel := make(chan bool)
	println("test 🤛")

	data_studentsdata_studentsSQL.InitDB()
	//data_studentsdata_studentsSQL.InitDB()
	go main_menu_controller.Set_Main_Menu_Controller()
	go login_controller.Set_Login_Controller()
	// Listen and Server in 0.0.0.0:8080

	<- channel
}
