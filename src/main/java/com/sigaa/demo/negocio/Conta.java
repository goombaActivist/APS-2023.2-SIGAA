package com.example.demo.negocio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Conta {
    
    @Id
    private Long id;
    private String numero;


    public Conta(Long id, String numero) {
        this.setId(id);
        this.setNumero(numero);
    }

    public Conta () {
        
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNumero() {
        return numero;
    }


    public void setNumero(String numero) {
        this.numero = numero;
    }

    

}
