package com.ftn.sbnz.model;

import java.io.Serializable;
import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

@Role(Role.Type.EVENT)
@Timestamp("timestamp")
@Expires("2h")
public class LogEntry implements Serializable {
    private int id;
    private Date timestamp;
    private String source;
    private String ipAddress;
    private LogType logType;
    private String content;

    // Constructor
    public LogEntry(int id, Date timestamp, String source, String ipAddress,LogType logType, String content) {
        this.id = id;
        this.timestamp = timestamp;
        this.source = source;
        this.ipAddress = ipAddress;
        this.logType = logType;
        this.content = content;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Date getTimestamp() { return timestamp; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }
    public LogType getLogType() { return logType; }
    public void setLogType(LogType logType) { this.logType = logType; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    @Override
    public String toString() {
        return "LogEntry{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", source='" + source + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", logType=" + logType +
                ", content='" + content + '\'' +
                '}';
    }
    
    // TODO: čitanje podataka iz fajlova i konvertovanje u objekte LogEntry
    public LogEntry parse(String logEntry){
        return null;
    }
}
