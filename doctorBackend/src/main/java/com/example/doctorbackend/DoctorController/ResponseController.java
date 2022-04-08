package com.example.doctorbackend.DoctorController;

import com.example.doctorbackend.model.Patient_responses;
import com.example.doctorbackend.model.Questions;
import com.example.doctorbackend.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @GetMapping("/doctor/response/questions/{sectionId}")
    public List<Questions> getQuestionBySectionId(@PathVariable long sectionId){
        return responseService.getQuestionBySectionId(sectionId);
    }

    @GetMapping("/doctor/response/{sectionId}/{patientId}")
    public List<Patient_responses> getResponseBySectionId(@PathVariable long sectionId, @PathVariable long patientId){
        System.out.println("Enter point of controller");
        List<Patient_responses> resultSet = responseService.getResponseBySectionId(sectionId, patientId);
        System.out.println("CONTROLLER -->>> "+resultSet);
        return resultSet;
    }
}
