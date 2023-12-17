package com.example.demo.comunicacao;

import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.negocio.Cliente;
import com.example.demo.negocio.Conta;
import com.example.demo.negocio.Fachada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ClienteController {

    @Autowired
    private Fachada fachada;
    private static final AtomicLong idCounter = new AtomicLong();

    @GetMapping("/cliente")
    public String getClientes(Model model) {
        model.addAttribute("clientes", fachada.getAllClientes());
        return "clientes";
    }

    @GetMapping("/cliente/inserir/")
    public String novoCliente(@RequestParam(name = "nome") String nome){
        Conta conta = new Conta(idCounter.get(), String.valueOf(idCounter.get()));
        fachada.inserirConta(conta);
        Cliente cliente = new Cliente(idCounter.getAndIncrement(), nome, conta);
        fachada.inserirCliente(cliente);
        return "redirect:/cliente";
    }

}