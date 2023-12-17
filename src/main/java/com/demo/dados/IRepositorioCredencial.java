package com.example.demo.dados;

import com.example.demo.negocio.Credencial;


public interface IRepositorioCredencial{

    public void inserir(Credencial credencial);

    public Iterable<Credencial> getAll();

}