package com.example.doctorbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name= "SECTIONS_SEQUENCE", initialValue=0, allocationSize = 1)
public class Section {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECTIONS_SEQUENCE")
    private Long Id;

    private String title;

//    @JsonIgnore
    @OneToMany(mappedBy = "section")
    private List<Questions> question;

//    @JsonIgnore
    @OneToMany(mappedBy="section")
    private List<Patient_progress> patient_progress;


    public Section() {
    }

    public Section(Long id, String title, List<Questions> question, List<Patient_progress> patient_progress) {
        Id = id;
        this.title = title;
        this.question = question;
        this.patient_progress = patient_progress;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonManagedReference
    public List<Questions> getQuestion() {
        return question;
    }

    public void setQuestion(List<Questions> question) {
        this.question = question;
    }

//    @JsonManagedReference
    @JsonBackReference
    public List<Patient_progress> getPatient_progress() {
        return patient_progress;
    }

    public void setPatient_progress(List<Patient_progress> patient_progress) {
        this.patient_progress = patient_progress;
    }
}
