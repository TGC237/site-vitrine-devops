package com.tgc.vitrine;

import com.tgc.vitrine.model.Dashboard;
import com.tgc.vitrine.repository.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    private DashboardRepository dashboardRepository;

    @GetMapping("/")
    public String index(Model model) {
        Dashboard dashboard = dashboardRepository.findLatestStatus();
        if (dashboard == null) {
            dashboard = new Dashboard();
            dashboard.setSiteStatus("NO DATA");
        }
        model.addAttribute("dashboard", dashboard);
        return "index";
    }

    @GetMapping("/data/mission_control.json")
    @ResponseBody
    public Dashboard getMissionControlData() {
        Dashboard data = dashboardRepository.findLatestStatus();
        return (data != null) ? data : new Dashboard();
    }
}
