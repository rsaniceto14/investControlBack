package com.raphael.investControlApi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "logs")

public class UserLog {

    @Id
    private String id;
    privar String userName;
    private String action;
    private LocalDateTime timestamp;

    public UserLog() {}

    public UserLog(String userName, String action) {
        this.userName = userName;
        this.action = action;
        this.timestamp = LocalDateTime.now();
    }
    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    @Override
}