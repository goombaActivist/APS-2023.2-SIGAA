package com.example.demo.dados;

import com.example.demo.negocio.Conta;

import org.springframework.data.repository.CrudRepository;

public interface ContaDAO extends CrudRepository<Conta, Long> {
    
}
