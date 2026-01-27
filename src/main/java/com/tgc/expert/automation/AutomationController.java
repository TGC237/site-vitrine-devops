package com.tgc.expert.automation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AutomationController {
    @GetMapping("/expertise/automation")
    public String automationPage() {
        return "pages/automation";
    }
}
