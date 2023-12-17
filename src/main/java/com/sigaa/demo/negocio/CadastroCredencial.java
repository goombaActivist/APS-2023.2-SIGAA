package com.example.demo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dados.IRepositorioCredencial;

@Component
public class CadastroCredencial {
    
    @Autowired
    private IRepositorioCredencial repositorioCredencial;

    public Iterable<Credencial> getAll(){

        return repositorioCredencial.getAll();
    }

    public void inserir(Credencial credencial){
        repositorioCredencial.inserir(credencial);
    }
}
