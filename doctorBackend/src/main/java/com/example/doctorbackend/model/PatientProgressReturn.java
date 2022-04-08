package com.example.doctorbackend.model;

import java.util.List;

public class PatientProgressReturn {
    private Patient patient;
    private List<Section> section;

    public PatientProgressReturn() {
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Section> getSection() {
        return section;
    }

    public void setSection(List<Section> section) {
        this.section = section;
    }
}
