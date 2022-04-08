package com.example.doctorbackend.repo;

import com.example.doctorbackend.model.Doctor;
import com.example.doctorbackend.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
