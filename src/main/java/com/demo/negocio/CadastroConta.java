package com.example.demo.negocio;

import com.example.demo.dados.IRepositorioConta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroConta {
    
    @Autowired
    private IRepositorioConta repositorioConta;

    public void inserir(Conta conta) {
        repositorioConta.inserir(conta);
    }
    
}
