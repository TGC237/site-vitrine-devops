package com.tgc.expert.infrastructure;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfrastructureController {

    @GetMapping("/expertise/infrastructure")
    public String infraPage() {
        return "pages/infrastructure";
    }
}
