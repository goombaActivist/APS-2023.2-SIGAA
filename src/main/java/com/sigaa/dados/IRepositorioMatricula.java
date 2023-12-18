package com.sigaa.dados;

import com.sigaa.negocios.Matricula;

public interface IRepositorioMatricula {

    public Iterable<Matricula> getAll();

    // public Iterable<Matricula> atualizaDB();

    public <A> A consultarDisciplinas();

    public <A> A consultarTurmas();

    public <A> void confirmarMatricula(A disciplinas, Integer id);

}
