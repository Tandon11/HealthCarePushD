package com.example.doctorbackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
//@SequenceGenerator(name= "PATIENT_PROGRESS_SEQUENCE", initialValue=1, allocationSize = 1)
public class Patient_progress {


//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATIENT_PROGRESS_SEQUENCE")
    @Id
    @Column(name="pat_id", nullable = false)
    private Long id;


    @OneToOne
    @MapsId
    @JoinColumn(name="pat_id")
    private Patient patient;

//    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Section section;

    public Patient_progress() {
    }

    public Patient_progress(Long id, Patient patient, Section section) {
        this.id = id;
        this.patient = patient;
        this.section = section;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

//    @JsonBackReference
    @JsonManagedReference
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
