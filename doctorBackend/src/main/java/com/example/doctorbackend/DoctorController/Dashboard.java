package com.example.doctorbackend.DoctorController;

import com.example.doctorbackend.model.*;
import com.example.doctorbackend.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class Dashboard {

    @Autowired
    DashboardService dashboardService;

    @GetMapping("doctor/{username}")
    public Doctor findDoctorByUsername(@PathVariable String username){
        return dashboardService.findDoctorByUsername(username);
    }

    @GetMapping("/doctor/dashboard/{doctorId}/patients")
    public List<Patient> findPatientByDoctor(@PathVariable Long doctorId){
        System.out.println("Controller "+doctorId);

        List<Patient> patients = dashboardService.findPatientByDoctorService(doctorId);

        List<Patient> resultSet = new ArrayList<>();
        for(Patient patient: patients){
//            patient.setDoctor(null);
            resultSet.add(patient);
        }
        return patients;
    }

    @GetMapping("/doctor/dashboard/{patientId}/mood")
    public List<PatientMood> findPatientMood(@PathVariable Long patientId){
        return dashboardService.findPatientMood(patientId);
    }

    @GetMapping("/doctor/dashboard/{patientId}/patient")
    public Patient getPatientDetails(@PathVariable Long patientId){
        Patient patient = dashboardService.findPatientDetails(patientId);
        System.out.print("Control --->>>> "+patient);
        return patient;
    }

    @GetMapping("/doctor/dashboard/{patientId}/progress")
    public PatientProgressReturn getPatientProgress(@PathVariable Long patientId){
        PatientProgressReturn patientProgressReturn =  dashboardService.getPatientProgress(patientId);

//        System.out.println("CONTROLLER PROGRESS--->>>> "+patient_progress);
//        Patient_progress result = new Patient_progress();
//        result.setPatient(patient_progress.getPatient());
//        result.setSection(patient_progress.getSection());
        System.out.println("CONTROLLER PROGRESS--->>>> "+patientProgressReturn);
        return patientProgressReturn; //section id not getting in the json format;
    }

    @GetMapping("/doctor/dashboard/{doctorId}/availability")
    public ResponseEntity<String> updateDoctorAvailabilit(@PathVariable Long doctorId){
        dashboardService.updateDoctorIsAvail(doctorId);
        return new ResponseEntity<>("Updation Done!", HttpStatus.OK);
    }

}
