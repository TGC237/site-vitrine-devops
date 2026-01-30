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

    private int jenkinsBuildNumber;
    private String jenkinsStatus;
    private double ramUsageGb;
    private String siteStatus;
    private LocalDateTime lastUpdate;
}
