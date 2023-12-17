package com.example.demo.comunicacao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainMenuController {
    

    @GetMapping("/mainMenu")
    public String menuPrincipal(){
        return "mainMenu";
    }
}
