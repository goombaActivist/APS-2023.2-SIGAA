package com.sigaa.negocios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sigaa.dados.CadastroMatricula;

@Component
public class ControladorMatricula {
    
    @Autowired
    private CadastroMatricula cadastroMatricula;

    private Iterable<Matricula> matriculas;

    public Iterable<Matricula> getAll(){
        return cadastroMatricula.getAll();
    }

    // public Iterable<Matricula> atualizaDB(){
    //     return cadastroMatricula.atualizaDB();
    // }

    public <A> A consultarDisciplinas(){
        return cadastroMatricula.consultarDisciplinas();
    }

    public <A> A consultarTurmas(){
        return cadastroMatricula.consultarTurmas();
    }

    public <A> void confirmarMatricula(A disciplinas, Integer id){
        cadastroMatricula.confirmarMatricula(disciplinas, id);
    }
}
