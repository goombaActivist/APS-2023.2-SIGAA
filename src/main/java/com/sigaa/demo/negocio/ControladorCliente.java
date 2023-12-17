package com.example.demo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControladorCliente {

    @Autowired
    private CadastroCliente cadastroCliente;

    public void inserir(Cliente cliente) {
        cadastroCliente.inserir(cliente);
    }

    public Iterable<Cliente> getAll() {
        return cadastroCliente.getAll();
    }
    
}
