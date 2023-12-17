package com.example.demo.dados;

import com.example.demo.negocio.Credencial;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositorioCredencialSpring implements IRepositorioCredencial{
    
    @Autowired
    private CredencialDAO credencialDAO;
    
    @Override
    public Iterable<Credencial> getAll(){
        return credencialDAO.findAll();
    }

    @Override
    public void inserir(Credencial credencial){
        credencialDAO.save(credencial);
    }

}
