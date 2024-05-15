package com.ftn.sbnz.model;

import java.io.Serializable;

//ovaj model treba da se unapredi jer ne postoji jos threat type 
public class Threat implements Serializable{
    
    private int id;
    private String description;
    private String source;
    private RiskLevel riskLevel;
    //private ThreatType threatType;

    // Constructor
    public Threat(int id, String description, String source, RiskLevel riskLevel){//, ThreatType threatType) {
        this.id = id;
        this.description = description;
        this.source = source;
        this.riskLevel = riskLevel;
        //this.threatType = threatType;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public RiskLevel getRiskLevel() { return riskLevel; }
    public void setRiskLevel(RiskLevel riskLevel) { this.riskLevel = riskLevel; }
    //public ThreatType getThreatType() { return threatType; }
    //public void setThreatType(ThreatType threatType) { this.threatType = threatType; }

}
