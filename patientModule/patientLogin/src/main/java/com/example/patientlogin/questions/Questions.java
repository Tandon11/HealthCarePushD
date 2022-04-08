package com.example.patientlogin.questions;

import com.example.patientlogin.patient_responses.PatientResponses;
import com.example.patientlogin.section.Section;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Questions {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String question;

    public Questions(String question) {
        this.question = question;
    }

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "section")
    @JsonIgnore
    private Section section;

//    @JsonManagedReference
    @OneToMany(mappedBy = "questions")
    private List<PatientResponses> patientResponses;


    public Long getId() {
        return id;
    }

    public void setId(Long q_no) {
        this.id = q_no;
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
    public List<PatientResponses> getPatientResponses() {
        return patientResponses;
    }

    public void setPatientResponses(List<PatientResponses> patientResponses) {
        this.patientResponses = patientResponses;
    }
}
