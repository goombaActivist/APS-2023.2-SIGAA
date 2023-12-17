package com.example.demo.dados;

import com.example.demo.negocio.Conta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositorioContaSpring implements IRepositorioConta {

    @Autowired
    private ContaDAO contaDAO;

    @Override
    public void inserir(Conta conta) {
        contaDAO.save(conta);    
    }

    
}
