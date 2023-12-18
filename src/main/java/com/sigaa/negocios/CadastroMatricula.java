package com.sigaa.dados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sigaa.negocios.Matricula;

@Component
public class CadastroMatricula {
    
    @Autowired
    private IRepositorioMatricula repositorioMatricula;

    public Iterable<Matricula> getAll(){
        return repositorioMatricula.getAll();
    }

    public Iterable<Matricula> atualizaDB(){
        return repositorioMatricula.atualizaDB();
    }

    public <A> A consultarTurmas(){
        return repositorioMatricula.consultarTurmas();
    }

    public <A> A consultarDisciplinas(){
        return repositorioMatricula.consultarDisciplinas();
    }

    public <A> void confirmarMatricula(A disciplinas, Integer id){
        repositorioMatricula.confirmarMatricula(disciplinas, id);
    }
}
