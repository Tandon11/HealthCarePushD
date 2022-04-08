package com.example.doctorbackend.repo;

import com.example.doctorbackend.model.Doctor;
import com.example.doctorbackend.model.Patient;
import com.example.doctorbackend.model.Questions;
import com.example.doctorbackend.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {

    List<Questions> findBySection(Section section);
}
