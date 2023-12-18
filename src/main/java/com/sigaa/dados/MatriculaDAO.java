package com.sigaa.dados;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.sigaa.negocios.Matricula;

@NoRepositoryBean //DAO := data abstraction object
public interface MatriculaDAO extends CrudRepository<Matricula, Integer> {}

