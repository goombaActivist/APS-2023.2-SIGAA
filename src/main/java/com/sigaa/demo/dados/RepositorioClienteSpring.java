package com.example.demo.dados;

import com.example.demo.negocio.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositorioClienteSpring implements IRepositorioCliente{

    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    public void inserir(Cliente cliente) {
        clienteDAO.save(cliente);
        
    }

    @Override
    public Iterable<Cliente> getAll() {
        return clienteDAO.findAll();
    }
    
}
