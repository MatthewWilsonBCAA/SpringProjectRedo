package com.ontrack.users;

import java.time.LocalDate;

public class User {
    private Long id;
    private String username;
    private String email;
    private LocalDate joined;
    public User(Long id, String username, String email, LocalDate joined) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.joined = joined;
    }
    public User(String username, String email, LocalDate joined) {
        this.username = username;
        this.email = email;
        this.joined = joined;
    }
    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getJoined() {
        return joined;
    }

    public void setJoined(LocalDate joined) {
        this.joined = joined;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", joined=" + joined +
                '}';
    }
}