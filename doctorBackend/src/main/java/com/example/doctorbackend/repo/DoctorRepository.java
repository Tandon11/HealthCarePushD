package com.example.doctorbackend.repo;

import com.example.doctorbackend.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    //username and it will return the admin of given username
    Doctor findByUsername(String username);

}
