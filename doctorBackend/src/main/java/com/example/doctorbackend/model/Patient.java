package com.example.doctorbackend.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@SequenceGenerator(name= "PATIENT_SEQUENCE", initialValue=1, allocationSize = 1)
public class Patient {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATIENT_SEQUENCE")
    private Long Id;

    private String email;
    private String fname;
    private String lname;
    private String password;
    private Boolean enabled=false;

//    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Doctor doctor;

//    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private List<Patient_responses> patient_responses;

//    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private List<PatientMood> patientMood;

    @OneToOne(mappedBy = "patient",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Patient_progress patientProgress;

    public Patient() {
    }

    public Patient(Long id, String email, String fname, String lname, String password) {
        Id = id;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
    }

    @JsonManagedReference
    public List<PatientMood> getPatientMood() {
        return patientMood;
    }

    public void setPatientMood(List<PatientMood> patientMood) {
        this.patientMood = patientMood;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    @JsonBackReference
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @JsonManagedReference
    public List<Patient_responses> getPatient_responses() {
        return patient_responses;
    }

    public void setPatient_responses(List<Patient_responses> patient_responses) {
        this.patient_responses = patient_responses;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "Id=" + Id +
                ", email='" + email + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(Id, patient.Id) && Objects.equals(email, patient.email) && Objects.equals(fname, patient.fname) && Objects.equals(lname, patient.lname) && Objects.equals(password, patient.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, email, fname, lname, password);
    }
}

