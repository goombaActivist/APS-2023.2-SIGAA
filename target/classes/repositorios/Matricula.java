package repositorios;

import java.util.Set;

import antlr.collections.List;

@Entity
@Table(name = "matricula")
public class Matricula {
  @Id
  private Integer CPF;
  
  private Boolean eMatriculado;
  
  private Set<String> disciplinas; 

  private Boolean eTrancado;
  
  public Matricula(Integer cpf) {
    this.CPF = cpf;
    this.eMatriculado = false;
    this.eTrancado = false;
    this.disciplinas = disciplinas.clear();
  }

  public Integer getCPF(){
    return this.CPF;
  }

  public Boolean get_eMatriculadBoolean(){
    return this.eMatriculado;
  }

  public List<String> getDisciplinas(){
    return this.disciplinas;
  }

  public <A> void adicionarDisciplina(A disciplina){ // A é placeholder até definir o tipo de disciplina
    boolean eDuplicado = this.disciplinas.add(disciplina);
    if(eDuplicado){
        System.err.println("Disciplina duplicada");
    };
    }

  public void removerDisciplina(String disciplina){

  }
}
