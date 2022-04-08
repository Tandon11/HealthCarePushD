package com.example.doctorbackend.repo;

import com.example.doctorbackend.model.Patient;
import com.example.doctorbackend.model.PatientMood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientMoodRepository extends JpaRepository<PatientMood, Long> {

    @Query(value = "from PatientMood where patient=?1 order by moodtime desc")
    List<PatientMood> findMood(Patient patient);
}
