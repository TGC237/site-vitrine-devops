package com.tgc.vitrine;

import com.tgc.vitrine.model.Dashboard;
import com.tgc.vitrine.repository.DashboardRepository;
import com.tgc.vitrine.repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private DashboardRepository dashboardRepository;

    @Autowired
    private ProfilRepository profilRepository;

    @GetMapping("/")
    public String index(Model model) {
        try {
            // 1. Récupération sécurisée du Dashboard (évite le plantage si la table est vide)
            Dashboard latestDashboard = Optional.ofNullable(dashboardRepository.findLatestStatus())
                                                .orElse(createDefaultDashboard());

            // 2. Récupération du profil
            var monProfil = profilRepository.findAll().stream().findFirst().orElse(null);

            // 3. Injection dans le modèle
            model.addAttribute("dashboard", latestDashboard);
            model.addAttribute("profil", monProfil);

            return "index";
        } catch (Exception e) {
            // Log d'erreur propre
            System.err.println("CRITICAL ERROR: " + e.getMessage());
            return "error"; 
        }
    }

    /**
     * API pour le rafraîchissement dynamique du dashboard
     */
    @GetMapping("/data/mission_control.json")
    @ResponseBody
    public Dashboard getMissionControlApi() {
        // On retourne les données réelles ou un objet par défaut pour éviter le crash JS
        return Optional.ofNullable(dashboardRepository.findLatestStatus())
                       .orElse(createDefaultDashboard());
    }

    /**
     * Helper pour créer un état par défaut (Dashboard "Safe Mode")
     */
    private Dashboard createDefaultDashboard() {
        Dashboard def = new Dashboard();
        def.setSiteStatus("UNKNOWN");
        def.setJenkinsStatus("STABLE");
        def.setRamUsageGb(0.0);
        def.setJenkinsBuildNumber(0);
        def.setSonarStatus("N/A");
        return def;
    }
}
