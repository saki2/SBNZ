package com.ftn.sbnz.model;

import java.io.Serializable;
import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

@Role(Role.Type.EVENT)
@Timestamp("timestamp")
@Expires("2h")
public class Alarm implements Serializable {
    private int id;
    private Date timestamp;
    private String content;
    private Mitigation mitigation;

    // Constructor
    public Alarm(int id, Date timestamp, String content, Mitigation mitigation) {
        this.id = id;
        this.timestamp = timestamp;
        this.content = content;
        this.mitigation = mitigation;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Date getTimestamp() { return timestamp; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Mitigation getMitigation() { return mitigation; }
    public void setMitigation(Mitigation mitigation) { this.mitigation = mitigation; }

    @Override
    public String toString() {
        return "Alarm{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", content='" + content + '\'' +
                ", mitigation=" + mitigation +
                '}';
    }
}
