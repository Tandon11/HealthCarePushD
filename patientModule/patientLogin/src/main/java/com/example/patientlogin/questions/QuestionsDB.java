package com.example.patientlogin.questions;

import com.example.patientlogin.section.Section;
import com.example.patientlogin.section.SectionRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class QuestionsDB {


    private final QuestionsRepo questionsRepo;
    private final SectionRepo sectionRepo;

//    @Autowired
//    public QuestionsDB(QuestionsRepo questionsRepo)
//    {
//        this.questionsRepo = questionsRepo;
//    }

// kinda function lo single lines at 46,61,76 ni uncomment cheyi and comment 32,33,34 if the below code wont work
    public void addQuestions()
    {
//        Section s0 = new Section();
//        s0.setTitle("0. false");

        Section s1 = new Section();
        Section s2 = new Section();
        Section s3 = new Section();
        s1.setTitle("Beginner");
        s2.setTitle("Intermediate");
        s3.setTitle("Advanced");
//        sectionRepo.save(s0);
        sectionRepo.save(s1);
        sectionRepo.save(s2);
        sectionRepo.save(s3);
        Questions q1 = new Questions("Do you feel lonely always?");
        Questions q2 = new Questions("Did you engage in any social activities ?");
        Questions q3 = new Questions("Do you go outside for the weekends?");

//        Section s1 = sectionRepo.getById(1l);
        q1.setSection(s1);
        q2.setSection(s1);
        q3.setSection(s1);
        ArrayList<Questions> l1 = new ArrayList<>();
        l1.add(q1);
        l1.add(q2);
        l1.add(q3);
        s1.setQuestionList(l1);
        questionsRepo.saveAll(l1);
        //--------------------------------------------

        Questions q4 = new Questions("Do you talk to your parents or relatives frequently?");
        Questions q5 = new Questions("Do you feel comfortable in crowdy areas?");
        Questions q6 = new Questions("Do you have a pet at home?");
//        Section s2 = sectionRepo.getById(2l);
        q4.setSection(s2);
        q5.setSection(s2);
        q6.setSection(s2);
        ArrayList<Questions> l2 = new ArrayList<>();
        l2.add(q4);
        l2.add(q5);
        l2.add(q6);
        s2.setQuestionList(l2);
        questionsRepo.saveAll(l2);

        Questions q7 = new Questions("Are you an early bird?");
        Questions q8 = new Questions("Do you worry too often if things dont go your way?");
        Questions q9 = new Questions("Do you feel afraid if something awful might happen?");

//        Section s3 = sectionRepo.getById(3l);
        q7.setSection(s3);
        q8.setSection(s3);
        q9.setSection(s3);
        ArrayList<Questions> l3 = new ArrayList<>();
        l3.add(q7);
        l3.add(q8);
        l3.add(q9);
        s3.setQuestionList(l3);
        questionsRepo.saveAll(l3);
    }
}
