package com.example.demo.dados;

import com.example.demo.negocio.Cliente;

public interface IRepositorioCliente {


    public void inserir(Cliente cliente);

    public Iterable<Cliente> getAll();
    
}
