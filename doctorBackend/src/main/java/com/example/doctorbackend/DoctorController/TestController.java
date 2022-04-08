package com.example.doctorbackend.DoctorController;

import com.example.doctorbackend.model.*;
import com.example.doctorbackend.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TestController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientMoodRepository patientMoodRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private QuestionsRepository questionsRepository;

    @Autowired
    private PatientResponseRepository patientResponseRepository;

    @Autowired
    private PatientProgressRepository patientProgressRepository;

    @GetMapping("/addDoctor")
    public List<PatientMood> addDoctor() {
        Doctor d1 = new Doctor();
        Long doc_id = d1.getId();

        d1.setPassword("$2a$10$/jSkWocHkD8dXbmvuaL6ou4oaUYy19ji/0XZ3qqnnL25U93udguLe");
        d1.setUsername("doctor");
        d1.setFname("Benjamin");
        d1.setLname("Bratt");
        d1.setIs_Avail("true");

        doctorRepository.save(d1);

        return null;
    }

    @GetMapping("/add")
    public List<PatientMood> test(){
        Doctor d1 = new Doctor();
//        Long doc_id = d1.getId();

        d1.setPassword("$2a$10$/jSkWocHkD8dXbmvuaL6ou4oaUYy19ji/0XZ3qqnnL25U93udguLe");
        d1.setUsername("doctor");
        d1.setFname("Benjamin");
        d1.setLname("Bratt");
        d1.setIs_Avail("true");

        doctorRepository.save(d1);
//*************************SECTIONS*************************************************
        Section s0 = new Section();
        s0.setTitle("0. false");

        Section s1 = new Section();
        s1.setTitle("1. Beginner");

        Section s2 = new Section();
        s2.setTitle("2. Advance");

        Section s3 = new Section();
        s3.setTitle("2. Advance");

        sectionRepository.save(s0);
        sectionRepository.save(s1);
        sectionRepository.save(s2);
        sectionRepository.save(s3);

//*************************SECTIONS ENDS*************************************************

        Patient p1 = new Patient();
        p1.setFname("William");
        p1.setLname("johns");
        p1.setEmail("xyz@gmail.com");
        p1.setDoctor(d1);
//        p1.setPatient_responses(null);

        Patient p2 = new Patient();
        p2.setFname("James");
        p2.setLname("Charles");
        p2.setEmail("abc@gmail.com");
        p2.setDoctor(d1);
//        p2.setPatient_responses(null);

        Patient p3 = new Patient();
        p3.setFname("David");
        p3.setLname("spades");
        p3.setEmail("123@gmail.com");
        p3.setDoctor(d1);

        List<Patient> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        d1.setPatient(list);

        System.out.println(
                "********************JUST BEFORE SAVING***************************************"
        );
        patientRepository.save(p1);
        patientRepository.save(p2);

        System.out.println("Test contorller --->>>>>");
        System.out.println(d1);
        System.out.println(patientRepository.findByDoctor(d1));

//        System.out.println(
//                "********************MOOOOOOOOOOOOOOOOOOOOD***************************************"
//        );
//
//
//        PatientMood pm1 = new PatientMood();
//        pm1.setPatient(p1);
//        pm1.setMood(1);
//        pm1.setMoodTime(LocalDateTime.now());
//
//        PatientMood pm2 = new PatientMood();
//        pm2.setPatient(p1);
//        pm2.setMood(5);
//        pm2.setMoodTime(LocalDateTime.now().plusHours(1));
//
//        PatientMood pm3 = new PatientMood();
//        pm3.setPatient(p1);
//        pm3.setMood(4);
//        pm3.setMoodTime(LocalDateTime.now().plusHours(2));
//
//        PatientMood pm4 = new PatientMood();
//        pm4.setPatient(p1);
//        pm4.setMood(4);
//        pm4.setMoodTime(LocalDateTime.now().plusHours(3));
//
//        List<PatientMood> patientMoods = new ArrayList<>();
//        patientMoods.add(pm1);
//        patientMoods.add(pm2);
//        patientMoods.add(pm3);
//        patientMoods.add(pm4);
//
//        System.out.println("Before SAVING PATIENTMOOD");
//        p1.setPatientMood(patientMoods);
//        patientMoodRepository.saveAll(patientMoods);
//        patientMoodRepository.save(pm1);
//        patientMoodRepository.save(pm2);
//        patientMoodRepository.save(pm3);
//        patientMoodRepository.save(pm4);


        System.out.println("AFTER SAVING PATIENTMOOD");
//        System.out.println(patientMoodRepository.findAll());
//        System.out.println("OUR QUERY");
//        System.out.println(patientMoodRepository.findMood(p1));
//
//        List<PatientMood> resultSet = new ArrayList<>();
//        patientMoods = patientMoodRepository.findMood(p1);
//        int count = 0;
//        for(PatientMood patientMood: patientMoods){
//            if (count==3)
//                break;
//            count+=1;
//            patientMood.setPatient(null);
//            resultSet.add(patientMood);
//        }
//
//        System.out.println("PRINTING FINAL RESULT");
//        for(PatientMood patientMood: resultSet){
//            System.out.println(patientMood);
//        }
//        return resultSet;


        //********Section and Questions


//        ---------------------
        Questions q1 = new Questions();
        q1.setQuestion("how are you?");
        q1.setSection(s1);

        Questions q2 = new Questions();
        q2.setQuestion("how are you 2 ?");
        q2.setSection(s1);

        Questions q3 = new Questions();
        q3.setQuestion("how are you 3 ?");
        q3.setSection(s1);

        List<Questions> questions = new ArrayList<>();
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        s1.setQuestion(questions);

        questionsRepository.saveAll(questions);
//        ---------------------------------------
        Questions q4 = new Questions();
        q4.setQuestion("hows you day going 1 ?");
        q4.setSection(s2);

        Questions q5 = new Questions();
        q5.setQuestion("hows you day going 1 ?");
        q5.setSection(s2);

        Questions q6 = new Questions();
        q6.setQuestion("hows you day going 1 ?");
        q6.setSection(s2);

        List<Questions> questions2 = new ArrayList<>();
        questions2.add(q4);
        questions2.add(q5);
        questions2.add(q6);
        s2.setQuestion(questions2);

        questionsRepository.saveAll(questions2);

//        ------------------------------------------------
        Patient_responses pr1 = new Patient_responses();
        pr1.setPatient(p1);
        pr1.setQuestions(q1);
        pr1.setResponse(true);

        Patient_responses pr2 = new Patient_responses();
        pr2.setPatient(p1);
        pr2.setQuestions(q2);
        pr2.setResponse(false);

        Patient_responses pr3 = new Patient_responses();
        pr3.setPatient(p1);
        pr3.setQuestions(q3);
        pr3.setResponse(true);

        List<Patient_responses> patient_responses = new ArrayList<>();
        patient_responses.add(pr1);
        patient_responses.add(pr2);
        patient_responses.add(pr3);

        patientResponseRepository.saveAll(patient_responses);

        //-------------RESPONSE 2
        Patient_responses pr4 = new Patient_responses();
        pr4.setPatient(p1);
        pr4.setQuestions(q4);
        pr4.setResponse(true);

        Patient_responses pr5 = new Patient_responses();
        pr5.setPatient(p1);
        pr5.setQuestions(q5);
        pr5.setResponse(false);

        Patient_responses pr6 = new Patient_responses();
        pr6.setPatient(p1);
        pr6.setQuestions(q6);
        pr6.setResponse(true);

        List<Patient_responses> patient_responses2 = new ArrayList<>();
        patient_responses2.add(pr4);
        patient_responses2.add(pr5);
        patient_responses2.add(pr6);

        patientResponseRepository.saveAll(patient_responses2);

//        ----------------------------------
        Patient_progress pp1 = new Patient_progress();
        pp1.setPatient(p1);
        pp1.setSection(s2);
        List<Patient_progress> patient_progresses = new ArrayList<>();
        patient_progresses.add(pp1);
        s2.setPatient_progress(patient_progresses); //changed from s2 to s1
        patientProgressRepository.save(pp1);


        Patient_progress pp2 = new Patient_progress();
        pp2.setPatient(p2);
        pp2.setSection(s0);

        List<Patient_progress> patient_progresses2 = new ArrayList<>();
        patient_progresses2.add(pp2);
        s0.setPatient_progress(patient_progresses); //changed from s2 to s1
        patientProgressRepository.save(pp2);
        return null;
    }

    @GetMapping("/addAgain")
    public void testagain(){
        Doctor d1 = doctorRepository.getById((long)2);


        Patient p1 = new Patient();
        p1.setFname("krishna");
        p1.setDoctor(d1);

        List<Patient> list = d1.getPatient();
        System.out.println("Before save");
        for(Patient p: list){
            System.out.println(p.getFname());
        }
        list.add(p1);

        patientRepository.save(p1);


        Doctor d2 = doctorRepository.getById((long)2);
        List<Patient> list1 = d2.getPatient();
        System.out.println("After save");
        for(Patient p: list1){
            System.out.println(p.getFname());
        }
    }
}
