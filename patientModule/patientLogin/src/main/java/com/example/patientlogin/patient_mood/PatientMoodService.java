package com.example.patientlogin.patient_mood;

import com.example.patientlogin.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PatientMoodService {

    private final PatientMoodRepo patientMoodRepo;
    private final AppUserRepository appUserRepository;

    @Transactional
    public void saveMood(Integer mood, long pat_id)
    {
        PatientMood patientMood = new PatientMood();
//        patientMood.setMood(patientMoodRequest.getMood());
        patientMood.setAppUser(appUserRepository.getById(pat_id));
        patientMood.setMoodTime(LocalDateTime.now());
        patientMood.setMood(mood);
        patientMoodRepo.save(patientMood);

    }
}
