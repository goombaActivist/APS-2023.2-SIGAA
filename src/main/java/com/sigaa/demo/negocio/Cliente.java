package com.example.demo.negocio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cliente {

    @Id
    private Long id;
    private String nome;

    @OneToOne
    private Conta conta;

    public Cliente(Long id, String nome, Conta conta) {
        this.id = id;
        this.nome = nome;
        this.setConta(conta);
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Cliente () {

    }
    
    public String getNome() {
        return nome;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public String toString() {
        return this.id + " " + this.nome;
    }
}
