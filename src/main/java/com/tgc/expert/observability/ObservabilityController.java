package com.tgc.expert.observability;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ObservabilityController {
    @GetMapping("/expertise/observability")
    public String observabilityPage() {
        return "pages/observability";
    }
}
