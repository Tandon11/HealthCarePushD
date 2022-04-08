package com.example.doctorbackend.service;

import com.example.doctorbackend.model.GenerateLink;
import com.example.doctorbackend.model.Patient;
import com.example.doctorbackend.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkGenerationService {

    @Autowired
    private PatientRepository patientRepository;

    public boolean emailIsExist(GenerateLink generateLink){
        List<Patient> patient = patientRepository.findByEmail(generateLink.getPatEmail());
        if(patient.size()>=1)
            return false;
        else
            return true;
    }
}
