package com.example.patientlogin.patient_responses;

import com.example.patientlogin.questions.Questions;
import com.example.patientlogin.questions.QuestionsRepo;
import com.example.patientlogin.section.Section;
import com.example.patientlogin.section.SectionRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
@CrossOrigin(origins ="http://localhost:4200")
public class PatientResponsesController {

    private PatientResponsesService patientResponsesService;
    private SectionRepo sectionRepo;
    private QuestionsRepo questionsRepo;

    @GetMapping(value = "/questions/{pat_id}/{sec_id}")
    public List<Questions> getQuestions(@PathVariable String pat_id, @PathVariable Long sec_id)
    {
        Section section = sectionRepo.getById(sec_id);
        List<Questions> questions = questionsRepo.findBySection(section);
        for(Questions i : questions) {
            System.out.println("Question is " + i.getQuestion());
            System.out.println("Question number " + i.getId());
            System.out.println("Question section is  " + i.getSection());

        }
        return questions;
    }

    @PostMapping(value = "/patient/responses/{pat_id}/{sec_id}")
    public String storeResponses(@RequestBody PatientResponsesRequest patientResponsesRequest, @PathVariable long pat_id, @PathVariable long sec_id)
    {
        //,consumes = MediaType.APPLICATION_JSON_VALUE
//        long pat_id = 1;
        System.out.println("THe link is working");
        List<Long> l = patientResponsesRequest.getQuestions();
//        for(Questions i : l) {
//            System.out.println(i.getQuestion());
//            System.out.println(i.getQ_no());
//            System.out.println(i.getSection());
//            System.out.println(i.getPatientResponses());
//
//        }
        patientResponsesService.saveResponses(patientResponsesRequest,pat_id,sec_id);
        return "User responses stored!";
    }

}
