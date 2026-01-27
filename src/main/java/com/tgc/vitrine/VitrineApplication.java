package com.tgc.vitrine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// CRUCIAL : On dit à Spring de scanner AUSSI le dossier 'com.tgc.expert'
@SpringBootApplication(scanBasePackages = {"com.tgc.vitrine", "com.tgc.expert"})
@Controller
public class VitrineApplication {

    public static void main(String[] args) {
        SpringApplication.run(VitrineApplication.class, args);
    }

    // Route de la page d'accueil (Index)
    @GetMapping("/")
    public String index() {
        return "index"; 
    }

    // On garde ici uniquement les pages qui ne sont pas dans le dossier 'expert'
    @GetMapping("/documentation")
    public String documentation() {
        return "documentation"; 
    }
}
