package com.sigaa.dados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sigaa.negocios.Matricula;

@Component
public class RepositorioMatriculaSpring implements IRepositorioMatricula {
    
    @Autowired
    private MatriculaDAO matriculaDAO;

    public Iterable<Matricula> getAll(){
        return matriculaDAO.findAll();
    }

    public <A> A consultarDisciplinas(){
        return matriculaDAO.
    }
    

}
