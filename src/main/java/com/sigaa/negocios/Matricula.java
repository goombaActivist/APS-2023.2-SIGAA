package com.sigaa.dados;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import antlr.collections.List;

@Entity
@Table(name = "matricula")
public class Matricula<A> {
  @Id
  private Integer CPF;
  
  private Boolean eMatriculado;
  
  private Set<A> disciplinas; 

  private Boolean eTrancado;
  
  public Matricula(Integer cpf) {
    this.CPF = cpf;
    this.eMatriculado = false;
    this.eTrancado = false;
    this.disciplinas.clear();;
  }

  public Integer getCPF(){
    return this.CPF;
  }

  public Boolean get_eMatriculadBoolean(){
    return this.eMatriculado;
  }

  public Set<A> getDisciplinas(){
    return this.disciplinas;
  }

  public <A> void adicionarDisciplina(A disciplina){ // A é placeholder até definir o tipo de disciplina
    boolean eDuplicado = this.disciplinas.add(disciplina);
    if(eDuplicado){
        System.err.println("Disciplina duplicada");
    };
    }

  public void removerDisciplina(A disciplina){
    boolean eInexistente = this.disciplinas.remove(disciplina);
    if(eInexistente){
        System.err.println("Disciplina inexistente");
    }
  }
}
