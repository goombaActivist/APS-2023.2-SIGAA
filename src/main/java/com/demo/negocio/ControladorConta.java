package com.example.demo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControladorConta {

    @Autowired
    private CadastroConta cadastroConta;

    public void inserir(Conta conta) {
        cadastroConta.inserir(conta);
    }

    
}
