package com.tgc.vitrine.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "profil")
@Data
public class Profil {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prenom;
    private String nom;
    private String titre;
    private String origine;
    private String diplome;
    
    @Column(columnDefinition = "TEXT")
    private String bio;
    
    private String email;
    private String githubUrl;
    private String linkedinUrl;
    private Boolean isActive;
    
    private String instagramUrl;	
    private String tiktokUrl;
    private String youtubeUrl;
    private String facebookUrl;
    private String photoUrl;
}
