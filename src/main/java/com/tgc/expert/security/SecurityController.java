package com.tgc.expert.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Contrôleur gérant l'expertise Sécurité & Audit (DevSecOps).
 * Le but est de démontrer l'intégration de SonarQube et des normes de sécurité.
 */
@Controller
public class SecurityController {

    @GetMapping("/expertise/security")
    public String securityPage() {
        // Spring Boot cherchera le fichier dans : src/main/resources/templates/pages/security.html
        return "pages/security";
    }
}
