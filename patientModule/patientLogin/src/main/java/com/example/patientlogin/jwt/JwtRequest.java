package com.example.patientlogin.jwt;

public class JwtRequest {
    String email;
    String password;

    public JwtRequest() {

    }

    public JwtRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "JwtRequest{" +
                "username='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

