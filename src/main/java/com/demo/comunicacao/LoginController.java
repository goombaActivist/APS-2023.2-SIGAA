package com.example.demo.comunicacao;


import com.example.demo.negocio.Credencial;
import com.example.demo.negocio.Fachada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    //private static final AtomicLong idCounter = new AtomicLong();

    @Autowired
    private Fachada fachada;


    @GetMapping("/login")
    public String realizarLogin(Model model){
        //model.addAttribute(null, model);
        return "login";
    }

    @GetMapping("/login/autenticar")
    public String autenticarUsuario(@RequestParam(name="username") String username, @RequestParam(name="password") String password){
        Credencial credencial = new Credencial(username,password);
        Boolean existe = fachada.autenticarCredencial(credencial);

        if (existe) {
            return "redirect:/mainMenu";
        }else{
            return "redirect:/login";
        }

        
    }
    /*@GetMapping("/cliente/inserir/")
    public String novoCliente(@RequestParam(name = "nome") String nome){
        Conta conta = new Conta(idCounter.get(), String.valueOf(idCounter.get()));
        fachada.inserirConta(conta);
        Cliente cliente = new Cliente(idCounter.getAndIncrement(), nome, conta);
        fachada.inserirCliente(cliente);
        return "redirect:/cliente";
    }*/

}