package com.example.patientlogin.questions;

import com.example.patientlogin.section.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional()
public interface QuestionsRepo extends JpaRepository<Questions,Long> {

    List<Questions> findBySection(Section section);
}
