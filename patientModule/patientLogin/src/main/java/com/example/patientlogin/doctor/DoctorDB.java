package com.example.patientlogin.doctor;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DoctorDB {

    @Autowired
    DoctorRepo doctorRepo;


    public void addDoctor()
    {
        Doctor d1 = new Doctor();
//        Long doc_id = d1.getId();

        d1.setPassword("$2a$10$/jSkWocHkD8dXbmvuaL6ou4oaUYy19ji/0XZ3qqnnL25U93udguLe");
        d1.setUsername("doctor");
        d1.setFname("Benjamin");
        d1.setLname("Bratt");
        d1.setIs_Avail("true");

        doctorRepo.save(d1);
    }

    public Doctor getDoctor(Long doc_id)
    {
        return doctorRepo.getById(doc_id);
    }
}
