package com.example.doctorbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@SequenceGenerator(name= "PATIENT_RESPONSE_SEQUENCE", initialValue=1, allocationSize = 1)
public class Patient_responses {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATIENT_RESPONSE_SEQUENCE")
    private Long Id;

//    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Patient patient;

//    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Questions questions;

    private boolean response;

    public Patient_responses() {
    }

    public Patient_responses(Long id, Patient patient, Questions questions, Boolean response) {
        Id = id;
        this.patient = patient;
        this.questions = questions;
        this.response = response;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @JsonBackReference
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @JsonBackReference
    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }
}
