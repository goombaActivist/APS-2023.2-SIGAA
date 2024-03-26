package main

import (
	_ "github.com/joho/godotenv/autoload"
	scholarshipcontroller "scholarship/scholarship_controller"
	scholarshipsql "scholarship/scholarship_sql"
)

func main(){

	canal := make(chan bool)

	scholarshipsql.Init_DB()
	scholarshipcontroller.Set_scholarship_controller()

	<-canal


}