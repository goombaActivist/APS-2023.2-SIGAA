package main

import (
	"fmt"
	"log"
	"net/http"
	"strconv"

	"github.com/gin-gonic/gin"
	"github.com/hashicorp/consul/api"
)

func main() {
	// Configuração do cliente Consul
	config := api.DefaultConfig()
	consulClient, err := api.NewClient(config)
	if err != nil {
		log.Fatal("Erro ao criar cliente Consul:", err)
	}

	// Criação de um objeto Gin
	router := gin.Default()

	// Rota para obter um serviço registrado no Consul
	router.GET("/service/:name", func(c *gin.Context) {
		serviceName := c.Param("name")
		fmt.Print(serviceName)
		// Consulta o serviço no Consul
		entries, _, err := consulClient.Health().Service(serviceName, "", true, nil)
		if err != nil {
			c.JSON(500, gin.H{"error": "Erro ao consultar serviço no Consul"})
			return
		}

		if len(entries) > 0 {
			service := entries[0].Service
			/*c.JSON(200, gin.H{
				"service_name": service.Service,
				"address":      service.Address,
				"port":         service.Port,
			})*/
			c.Redirect(http.StatusMovedPermanently, "http://"+service.Address+":"+strconv.Itoa(service.Port)+"/"+service.ID)
			return
		}

		c.JSON(404, gin.H{"error": "Serviço não encontrado no Consul"})
	})

	// Executa o servidor Gin na porta 8080
	err = router.Run(":8079")
	if err != nil {
		log.Fatal("Erro ao iniciar o servidor Gin:", err)
	}
}