package com.example.doctorbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name= "QUESTIONS_SEQUENCE", initialValue=1, allocationSize = 1)
public class Questions {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="QUESTIONS_SEQUENCE")
    private Long Id;

    private String question;

//    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Section section;


//    @JsonIgnore
    @OneToMany(mappedBy = "questions")
    private List<Patient_responses> patient_responses;

    public Questions() {
    }

    public Questions(Long id, String question, Section section, List<Patient_responses> patient_responses) {
        Id = id;
        this.question = question;
        this.section = section;
        this.patient_responses = patient_responses;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @JsonBackReference
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @JsonManagedReference
    public List<Patient_responses> getPatient_responses() {
        return patient_responses;
    }

    public void setPatient_responses(List<Patient_responses> patient_responses) {
        this.patient_responses = patient_responses;
    }
}
