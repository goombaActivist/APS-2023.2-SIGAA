package com.example.demo.negocio;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Credencial {
    
    @Id
    private String user;
    private String senha;

    
    public Credencial(String user, String senha){

        this.user = user;
        this.senha = senha;
    }

    public Credencial (){

    }


    public void setUser(String user){
        this.user = user;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getUser(){
        return user;
    }

    public String getSenha(){
        return senha;
    }

    public String toString(){
        return this.user + " " + this.senha;
    }
}
