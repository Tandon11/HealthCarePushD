package com.example.doctorbackend.service;

import com.example.doctorbackend.model.Patient;
import com.example.doctorbackend.model.Patient_responses;
import com.example.doctorbackend.model.Questions;
import com.example.doctorbackend.model.Section;
import com.example.doctorbackend.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResponseService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private QuestionsRepository questionsRepository;

    @Autowired
    private PatientResponseRepository patientResponseRepository;

//    @Autowired
//    private PatientProgressRepository patientProgressRepository;


    public List<Questions> getQuestionBySectionId(long sectionId){
        Section section = sectionRepository.getById(sectionId);
        return questionsRepository.findBySection(section);
    }

    public List<Patient_responses> getResponseBySectionId(long sectionId, long patientId){
        System.out.println("ENTERY POINT OF SERVICE");
        Section section = sectionRepository.getById(sectionId);
        System.out.println("ENTERY POINT OF SERVICE 1");
        Patient patient = patientRepository.getById(patientId);
        System.out.println("ENTERY POINT OF SERVICE 2 ");
        List<Questions> questions = questionsRepository.findBySection(section);
        System.out.println("ENTERY POINT OF SERVICE 3");

        List<Patient_responses> resultSet = new ArrayList<>();
        for(Questions q: questions){
            resultSet.add(patientResponseRepository.findByQuestionsAndPatient(q, patient).get(0));
        }
        return resultSet;
    }
}
