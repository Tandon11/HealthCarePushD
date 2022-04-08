package com.example.patientlogin.patient_progress;

import com.example.patientlogin.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientProgressRepo extends JpaRepository<PatientProgress, Long> {
//    void save(Long pat_id, Long sec_id);
}
