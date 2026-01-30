package com.tgc.site.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "dashboard")
@Data // Génère automatiquement les getters/setters si tu as ajouté Lombok
public class Dashboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jenkins_build_number")
    private Integer jenkinsBuildNumber;

    @Column(name = "jenkins_status")
    private String jenkinsStatus;

    @Column(name = "ram_usage_gb")
    private Double ramUsageGb;

    @Column(name = "sonar_status")
    private String sonarStatus;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
   
    @Column(name = "site_status")
    private String siteStatus;

    // Si tu veux aussi la latence (optionnel mais recommandé pour ton dashboard)
    @Column(name = "response_latency_ms")
    private Integer responseLatencyMs;
}
