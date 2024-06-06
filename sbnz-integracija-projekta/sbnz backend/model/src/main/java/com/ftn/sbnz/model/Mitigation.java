package com.ftn.sbnz.model;

public class Mitigation {
    private int id;
    private String description;
    private Threat threat;

    public Mitigation(int id, String description, Threat threat) {
        this.id = id;
        this.description = description;
        this.threat = threat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Threat getThreat() {
        return this.threat;
    }

    public void setThreat(Threat threat){
        this.threat = threat;
    }

    @Override
    public String toString() {
        return "Mitigation{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", threat=" + threat +
                '}';
    }
 
    // TODO: make the recommendation specific to the threat, not vague
    public void recommendMitigation() {
        System.out.println("Recommended Mitigation: " + description);
    }

}
