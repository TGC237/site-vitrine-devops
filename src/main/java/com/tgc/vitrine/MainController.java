package com.tgc.vitrine;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        try {
            // 1. Charger le fichier JSON depuis les ressources
            ObjectMapper mapper = new ObjectMapper();
            ClassPathResource resource = new ClassPathResource("data/portfolio.json");
            
            // 2. Désérialiser le JSON en objet Java
            PortfolioData data = mapper.readValue(resource.getInputStream(), PortfolioData.class);
            
            // 3. Envoyer l'objet à la vue index.html
            model.addAttribute("portfolio", data);
            
           } catch (Exception e) {
 	   e.printStackTrace(); // Cela affichera l'erreur précise dans ton terminal/console
   	   model.addAttribute("error", e.getMessage());
   	   return "error"; 
	   }
        
        return "index";
    }
}
