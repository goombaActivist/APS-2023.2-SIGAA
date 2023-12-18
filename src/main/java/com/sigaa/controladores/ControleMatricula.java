package com.sigaa.controladores;

import org.springframework.web.bind.annotation.RestController;

import com.sigaa.dados.MatriculaDAO;
import com.sigaa.negocios.Fachada;
import com.sigaa.negocios.Matricula;

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class ControleMatricula {

    @Autowired
    private Fachada fachada;

    @GetMapping("/matricula")
    public String  getMatriculas(Model model) {
        model.addAttribute("criarMatriculas", fachada.getAll());
        return "criarMatriculas";
    }

    // @PostMapping("/matricula")
    // public Iterable<Matricula> atualizaDB(Iterable<Matricula> matriculas) {
    //     return this.repoMatricula.saveAll(matriculas); // logar o que é salvo no futuro
    // }
 
    @GetMapping("/disciplinas")
    public String  consultarDisciplinas(Model model) {
        model.addAttribute("criarDisciplinas", fachada.consultarDisciplinas());
        return "criarDisciplinas";
    }

    @GetMapping("/turmas")
    public String consultarTurmas(Model model){
        model.addAttribute("criarTurmas",fachada.consultarTurmas());
        return "criarTurmas";
    }

    public <A> void confirmarMatricula(A disciplinas, Integer id){
        this.matriculas.forEach(m -> {if(m.getCPF() == id){
            try {
                m.wait();
            } catch (InterruptedException e) {
                System.err.println("Erro na hora de confirmar a matrícula!");
                e.printStackTrace();
            }
            m.adicionarDisciplina(disciplinas); // tem que lidar com o generic
            m.notify();
        }});
    }



}