package com.example.demo.dados;

import com.example.demo.negocio.Credencial;

import org.springframework.data.repository.CrudRepository;


//Data Access Object
public interface CredencialDAO extends CrudRepository<Credencial, Long> {


}