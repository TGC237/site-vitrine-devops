package com.tgc.expert.management;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagementController {
    @GetMapping("/expertise/management")
    public String managementPage() {
        return "pages/management";
    }
}
