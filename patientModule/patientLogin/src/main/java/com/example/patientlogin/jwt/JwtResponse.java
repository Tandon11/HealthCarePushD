package com.example.patientlogin.jwt;

import lombok.Data;

@Data
public class JwtResponse {

    String token;
    String email;
    String fname;
    String lname;
    Long id;

    public JwtResponse() {
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