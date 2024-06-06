package com.ftn.sbnz.model;

import java.io.Serializable;

public class Admin implements Serializable {
    private int id;
    private String username;
    private String password;

    // Constructor
    public Admin(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean checkAlarm() {
        return true;
    }
}
