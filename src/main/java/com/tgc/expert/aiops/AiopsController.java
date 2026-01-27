package com.tgc.expert.aiops;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AiopsController {
    @GetMapping("/expertise/aiops")
    public String aiopsPage() {
        return "pages/aiops";
    }
}
