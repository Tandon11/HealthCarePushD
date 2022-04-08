package com.example.doctorbackend.repo;

import com.example.doctorbackend.model.Doctor;
import com.example.doctorbackend.model.Patient;
import com.example.doctorbackend.model.PatientMood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByDoctor(Doctor doctor);
    List<Patient> findByEmail(String email);


}
