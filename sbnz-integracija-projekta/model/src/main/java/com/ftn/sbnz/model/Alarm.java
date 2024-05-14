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
    private String logType;
    private String content;

    // Constructor
    public Alarm(int id, Date timestamp, String logType, String content) {
        this.id = id;
        this.timestamp = timestamp;
        this.logType = logType;
        this.content = content;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Date getTimestamp() { return timestamp; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
    public String getLogType() { return logType; }
    public void setLogType(String logType) { this.logType = logType; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
