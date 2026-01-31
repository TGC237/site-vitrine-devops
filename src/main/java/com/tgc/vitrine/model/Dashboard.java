package com.tgc.vitrine.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "dashboard")
@Data
public class Dashboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jenkins_build_number")
    private int jenkinsBuildNumber;

    @Column(name = "jenkins_status")
    private String jenkinsStatus;

    @Column(name = "ram_usage_gb")
    private double ramUsageGb;

    @Column(name = "site_status")
    private String siteStatus;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
	
    @Column(name = "sonar_status")
    private String sonarStatus;
}
