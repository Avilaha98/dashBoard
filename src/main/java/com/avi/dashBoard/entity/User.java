package com.avi.dashBoard.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_sessions")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = true)
    private String sessionId;

    @Column(nullable = false)
    private String username; // Store username instead of referencing User entity

    @Column(nullable = false)
    private String password; // Store hashed password

    @Transient 
    private LocalDateTime loginTime;

    public User() {
    }

    public User(String sessionId, String username, String password) {
        this.sessionId = UUID.randomUUID().toString(); // ✅ Generate unique session ID
        this.username = username;
        this.password = password;
        this.loginTime = LocalDateTime.now();
    }
    public User(String sessionId, String username) {
        this.sessionId = UUID.randomUUID().toString(); // ✅ Generate unique session ID
        this.username = username;
       
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }
}
