package com.example.patientlogin.section;

import com.example.patientlogin.patient_progress.PatientProgress;
import com.example.patientlogin.questions.Questions;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Section {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECTIONS_SEQUENCE")
    private Long sec_id;

    @Column
    private String title;

    @OneToMany(mappedBy = "section")
    private List<Questions> questionList;

    @OneToMany(mappedBy = "section")
    private List<PatientProgress> patient_progress;


    public Long getSec_id() {
        return sec_id;
    }

    public void setSec_id(Long sec_id) {
        this.sec_id = sec_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonManagedReference
    public List<Questions> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Questions> questionList) {
        this.questionList = questionList;
    }

    @JsonBackReference
    public List<PatientProgress> getPatient_progress() {
        return patient_progress;
    }

    public void setPatient_progress(List<PatientProgress> patient_progress) {
        this.patient_progress = patient_progress;
    }
}
