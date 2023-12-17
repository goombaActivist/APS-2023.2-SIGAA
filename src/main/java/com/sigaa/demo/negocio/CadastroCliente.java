package com.example.demo.negocio;

import com.example.demo.dados.IRepositorioCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroCliente {
    
    @Autowired
    private IRepositorioCliente repositorioCliente;

    public void inserir(Cliente cliente) {
        repositorioCliente.inserir(cliente);
    }

    public Iterable<Cliente> getAll() {
        return repositorioCliente.getAll();
    }
    
}
