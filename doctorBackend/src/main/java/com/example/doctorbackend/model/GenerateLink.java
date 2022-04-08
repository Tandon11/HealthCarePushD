package com.example.doctorbackend.model;


public class GenerateLink {
    private String doctorId;
    private String patEmail;
    private String patFname;

    public GenerateLink() {
    }

    public GenerateLink(String patEmail) {
        this.patEmail = patEmail;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatEmail() {
        return patEmail;
    }

    public void setPatEmail(String patEmail) {
        this.patEmail = patEmail;
    }

    public String getPatFname() {
        return patFname;
    }

    public void setPatFname(String patFname) {
        this.patFname = patFname;
    }


}
