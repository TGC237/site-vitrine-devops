package com.tgc.expert.architecture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArchitectureController {
    @GetMapping("/expertise/architecture")
    public String architecturePage() {
        return "pages/architecture";
    }
}
