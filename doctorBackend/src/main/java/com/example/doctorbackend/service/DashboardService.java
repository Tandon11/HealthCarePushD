package com.example.doctorbackend.service;

import com.example.doctorbackend.model.*;
import com.example.doctorbackend.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientMoodRepository patientMoodRepository;

    @Autowired
    private PatientProgressRepository patientProgressRepository;

    @Autowired
    private SectionRepository sectionRepository;

    public Doctor findDoctorByUsername(String username){
        Doctor doctor = doctorRepository.findByUsername(username);
        return doctor;
    }

    public List<Patient> findPatientByDoctorService(Long doctorId){
        Doctor doctor = doctorRepository.getById((long)doctorId);
        return patientRepository.findByDoctor(doctor);
    }


    public List<PatientMood> findPatientMood(Long patientId){
        Patient patient = patientRepository.getById((long) patientId);

        List<PatientMood> patientMoods = patientMoodRepository.findMood(patient);

        List<PatientMood> resultSet = new ArrayList<>();
        int count = 0;
        for(PatientMood patientMood: patientMoods){
            if (count==7)//taking top 7 results
                break;
            count+=1;
            patientMood.setPatient(null);
            resultSet.add(patientMood);
        }
        return resultSet;
    }


    public Patient findPatientDetails(Long patientId){
        Patient patient = patientRepository.findById(patientId).get();
        return patient;
    }

    public PatientProgressReturn getPatientProgress(Long patientId){
        Patient patient = patientRepository.getById((long) patientId);
        List<Patient_progress> patient_progress =  patientProgressRepository.findByPatient(patient);
        if(patient_progress.size()==0)
            return null;
        PatientProgressReturn progressProgressReturn = new PatientProgressReturn();
        progressProgressReturn.setPatient(patient);
        List<Section> sectionList = new ArrayList<>();
        for (int i=0;i<=patient_progress.get(0).getSection().getId();i++){
            sectionList.add(sectionRepository.getById((long) i));
        }
        progressProgressReturn.setSection(sectionList);
        System.out.println("PATIENT PROGRESS SERVICE ->>>> "+patient_progress);
        return progressProgressReturn;
    }
    public void updateDoctorIsAvail(Long id){
        Doctor doctor = doctorRepository.getById(id);
        if (doctor.getIs_Avail().equals("true")) {
            doctor.setIs_Avail("false");
            doctorRepository.save(doctor);
        }
        else{
            doctor.setIs_Avail("true");
            doctorRepository.save(doctor);
        }
    }
}
