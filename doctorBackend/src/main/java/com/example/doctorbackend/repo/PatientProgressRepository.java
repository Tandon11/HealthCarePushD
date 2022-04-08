package com.example.doctorbackend.repo;

import com.example.doctorbackend.model.Patient;
import com.example.doctorbackend.model.Patient_progress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientProgressRepository extends JpaRepository<Patient_progress, Long> {

    List<Patient_progress> findByPatient(Patient patient);
}
