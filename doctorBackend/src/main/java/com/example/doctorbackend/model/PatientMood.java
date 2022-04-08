package com.example.doctorbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@SequenceGenerator(name= "PATIENT_MOOD_SEQUENCE", initialValue=1, allocationSize = 1)
public class PatientMood {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATIENT_MOOD_SEQUENCE")
    private Long Id;

    private LocalDateTime moodTime;

    private Integer mood;

//    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Patient patient;

    public PatientMood() {
    }

    public PatientMood(Long id, LocalDateTime moodtime, Integer mood, Patient patient) {
        Id = id;
        this.moodTime = moodtime;
        this.mood = mood;
        this.patient = patient;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public LocalDateTime getMoodTime() {
        return moodTime;
    }

    public void setMoodTime(LocalDateTime moodTime) {
        this.moodTime = moodTime;
    }

    public Integer getMood() {
        return mood;
    }

    public void setMood(Integer mood) {
        this.mood = mood;
    }

    @JsonBackReference
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
