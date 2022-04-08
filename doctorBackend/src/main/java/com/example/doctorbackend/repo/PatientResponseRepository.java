package com.example.doctorbackend.repo;

import com.example.doctorbackend.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientResponseRepository extends JpaRepository<Patient_responses, Long> {

    List<Patient_responses> findByQuestionsAndPatient(Questions question, Patient patient);
}
