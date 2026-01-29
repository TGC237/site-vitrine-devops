package com.tgc.vitrine;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PortfolioData {
    public Map<String, Object> identite;
    public String a_propos;
    public List<Map<String, Object>> experiences;
    public List<String> competences;
    // Getters et Setters seront générés automatiquement par Spring/Jackson
    //constructeur vide requis par jackson
    public PortfolioData() {}
}
