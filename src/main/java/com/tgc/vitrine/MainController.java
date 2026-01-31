package com.tgc.vitrine;

import com.tgc.vitrine.model.Dashboard;
import com.tgc.vitrine.model.Profil;
import com.tgc.vitrine.repository.DashboardRepository;
import com.tgc.vitrine.repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    private DashboardRepository dashboardRepository;

    @Autowired
    private ProfilRepository profilRepository;

    // 1. LA PORTE D'ENTRÉE : Charge la coque (index.html)
    @GetMapping("/")
    public String index(Model model) {
        // On charge les données du Dashboard pour l'affichage initial
        Dashboard dashboard = dashboardRepository.findLatestStatus();
        model.addAttribute("dashboard", (dashboard != null) ? dashboard : new Dashboard());

        // On charge le profil pour que le nom/titre soit présent partout
        Profil profil = profilRepository.findById(1L).orElse(null);
        model.addAttribute("profil", profil);

        return "index";
    }

    // 2. LE MOTEUR DE NAVIGATION : Charge chaque section dynamiquement
    @GetMapping("/fragments/{name}")
    public String getFragment(@PathVariable String name, Model model) {
        // On récupère systématiquement le profil (besoin pour Profil, Expériences, Projets, Contact)
        Profil profil = profilRepository.findById(1L).orElse(null);
        model.addAttribute("profil", profil);

        // Si l'utilisateur demande le dashboard, on rafraîchit les métriques
        if (name.equals("dashboard")) {
            Dashboard dashboard = dashboardRepository.findLatestStatus();
            model.addAttribute("dashboard", (dashboard != null) ? dashboard : new Dashboard());
        }

        // Spring cherche automatiquement dans : src/main/resources/templates/fragments/[name].html
        return "fragments/" + name;
    }

    // 3. L'API JSON : Pour ton script de mise à jour automatique (Dashboard)
    @GetMapping("/data/mission_control.json")
    @ResponseBody
    public Dashboard getMissionControlData() {
        Dashboard data = dashboardRepository.findLatestStatus();
        return (data != null) ? data : new Dashboard();
    }
}

