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
	    // 1. On récupère le profil (ID 1L) pour toutes les sections
	    // Si profil est null, Thymeleaf plantera. On met un "new Profil()" par sécurité.
	    Profil profil = profilRepository.findById(1L).orElse(new Profil());
	    model.addAttribute("profil", profil);

	    // 2. Gestion spécifique du Dashboard
	    if ("dashboard".equals(name)) {
	        Dashboard dashboard = dashboardRepository.findLatestStatus();
	        model.addAttribute("dashboard", (dashboard != null) ? dashboard : new Dashboard());
	    }

            // 3. LOG DE DEBUG (Très utile pour toi en console)
            System.out.println("DEBUG: Requête reçue pour le fragment: " + name);
	    // Spring cherche dans : src/main/resources/templates/fragments/[name].html
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

