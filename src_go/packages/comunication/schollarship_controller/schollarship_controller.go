package schollarshipcontroller

import (
	"fmt"
	"net/http"

	"github.com/gin-gonic/gin"
	"sigaa.ufpe/packages/busines/facade"
)


func schollarship_Controller() *gin.Engine {

	r := gin.Default()
	var username string

	r.LoadHTMLGlob("packages/view/Schollarship/*")

	r.GET("/scholarship", func(ctx *gin.Context) {
		username = ctx.Query("studentUser")
		fmt.Println(username)
		ctx.HTML(http.StatusOK, "schollarship_main.html", gin.H{
			"title":                "Scholarships",
			"title1":               "Teaching Scholarships",
			"teachingScholarships": facade.GetAllTeachingScholarships(),
		})
	})

	r.GET("/mainMenu", func(ctx *gin.Context) {
		ctx.Redirect(http.StatusPermanentRedirect, "http://localhost:8081/mainMenu")
	})

	r.GET("/teachingScholarship", func(ctx *gin.Context) {
		ctx.Redirect(http.StatusPermanentRedirect, "http://localhost:8083/teachingScholarship")
	})


	return r
}


func Set_Schollarship_Controller() {

	r := schollarship_Controller()
	r.Run(":8082")
}
