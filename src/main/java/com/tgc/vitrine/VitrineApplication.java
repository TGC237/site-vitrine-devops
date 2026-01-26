package com.tgc.vitrine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class VitrineApplication {

    public static void main(String[] args) {
        SpringApplication.run(VitrineApplication.class, args);
    }
	// Route de la page acceuil index
    @GetMapping("/")
    public String index() {
        return "index"; // Cela va chercher le fichier src/main/resources/templates/index.html
    }
	// Route pour la page Architecture
    @GetMapping("/architecture")
    public String architecture() {
        return "architecture"; // Cherche le fichier architecture.html
    }

    	// Route pour la page Documentation
    @GetMapping("/documentation")
    public String documentation() {
        return "documentation"; // Cherche le fichier documentation.html
    }
}
