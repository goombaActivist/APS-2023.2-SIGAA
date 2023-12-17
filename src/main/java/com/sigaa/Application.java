package com.sigaa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args ->

            System.out.println("let's inspect the provided beans!");

            // for(String b : ctx.getBeanDefinitionNames()){
            //     System.out.println("look at this bean: " + b);
            // };
    }

}
