package com.ftn.sbnz.model;

import java.io.Serializable;
import java.util.Arrays;

public class Threat implements Serializable{
    
    private int id;
    private String description;
    private RiskLevel riskLevel;
    private ThreatType threatType;
    private LogEntry[] logEntries;

    // Constructor
    public Threat(int id, String description, RiskLevel riskLevel, ThreatType threatType, LogEntry[] logEntries) {
        this.id = id;
        this.description = description;
        this.riskLevel = riskLevel;
        this.threatType = threatType;
        this.logEntries = logEntries;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public RiskLevel getRiskLevel() { return riskLevel; }
    public void setRiskLevel(RiskLevel riskLevel) { this.riskLevel = riskLevel; }
    public ThreatType getThreatType() { return threatType; }
    public void setThreatType(ThreatType threatType) { this.threatType = threatType; }
    public LogEntry[] getLogEntries() { return logEntries; }
    public void setLogEntries(LogEntry[] logEntries) { this.logEntries = logEntries; }

    @Override
    public String toString() {
        return "Threat{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", riskLevel=" + riskLevel +
                ", threatType=" + threatType +
                ", logEntries=" + Arrays.toString(logEntries) +
                '}';
    }
}
