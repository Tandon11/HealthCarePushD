package com.example.patientlogin.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {


}
