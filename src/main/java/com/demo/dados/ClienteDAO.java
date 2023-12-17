package com.example.demo.dados;

import com.example.demo.negocio.Cliente;

import org.springframework.data.repository.CrudRepository;

// Data Access Object
public interface ClienteDAO extends CrudRepository<Cliente, Long>  {
    
}
