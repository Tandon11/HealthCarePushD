package com.example.doctorbackend.model;

public class JwtResponse {
    String token;
    String username;
    String fname;
    String lname;
    String isAvail;
    Long id;
    public JwtResponse() {
    }

    public String getIsAvail() {
        return isAvail;
    }

    public void setIsAvail(String isAvail) {
        this.isAvail = isAvail;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
