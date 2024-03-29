package API_GMAIL_PROAES

import (
	"fmt"
	"os"

	"gopkg.in/gomail.v2"
	proaes "sigaa.ufpe/packages/data/proaes_data"
)

type PROAES_Email struct {
	PROAES  proaes.PROAES
	Subject string
	Message string
}

func Send_Proaes_Email() {

	m := gomail.NewMessage()
	m.SetHeader("From", string(os.Getenv("EMAIL_SENDER_ADDRESS")))
	m.SetHeader("To", string(os.Getenv("EMAIL_RECEIVER")))
	m.SetHeader("Subject", "New Aplication for a Scholarship!")
	m.SetBody("text/html", fmt.Sprintf("A ne applicatos for the schoalkrship *** from the student ***"))

	d := gomail.NewDialer("smtp.gmail.com", 587, string(os.Getenv("EMAIL_SENDER_ADDRESS")), string(os.Getenv("GMAIL_KEY")))
	if err := d.DialAndSend(m); err != nil{
		panic(err)
	}
}
