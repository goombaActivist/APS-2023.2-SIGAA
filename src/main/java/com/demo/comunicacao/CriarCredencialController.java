package com.example.demo.comunicacao;

import com.example.demo.negocio.Credencial;
import com.example.demo.negocio.Fachada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
public class CriarCredencialController {
    

    @Autowired
    private Fachada fachada;

    @GetMapping("/credenciais")
    public String getCredenciasi(Model model){
        model.addAttribute("criarCredenciais", fachada.getAllCredentials());

        return "criarCredencial";
    }

    @GetMapping("/credenciais/inserir")
    public String adicionarCredenciais(@RequestParam(name="username") String username, @RequestParam(name="password") String password){

        Credencial credencial = new Credencial(username, password);
        fachada.inserirCredencial(credencial);

        return "redirect:/credenciais";
    }
}
