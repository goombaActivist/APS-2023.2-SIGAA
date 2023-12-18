package com.sigaa.negocios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sigaa.controladores.ControleMatricula;

@Component
public class Fachada {
    
    @Autowired
    private ControladorMatricula controladorMatricula;

    public Iterable<Matricula> getAll(){
        return controladorMatricula.getAll();
    }

    public <A> A consultarTurmas(){
        return controladorMatricula.consultarTurmas();
    }

    public <A> A consultarDisciplinas(){
        return controladorMatricula.consultarDisciplinas();
    }

    public <A> void confirmarMatricula(A discplinas, Integer id){
        controladorMatricula.confirmarMatricula(discplinas, id);
    }
}
