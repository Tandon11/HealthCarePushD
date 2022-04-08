package com.example.patientlogin.patient_mood;

import com.example.patientlogin.jwt.JwtResponse;
import com.example.patientlogin.jwt.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
@CrossOrigin(origins ="http://localhost:4200")
public class PatientMoodController {

    private final PatientMoodService patientMoodService;

    @PostMapping(value = "/patient/mood/{mood}/{pat_id}")
    public ResponseEntity<?> storeMood(@PathVariable Integer mood, @PathVariable long pat_id)
    {

        //@RequestBody PatientMoodRequest patientMoodRequest,@PathVariable long pat_id  /{pat_id}
        System.out.println("Entered the method!");
        System.out.println("MOod is from request " + mood);
        patientMoodService.saveMood(mood,pat_id);
//        return "User Mood stored!";
//        return new ResponseEntity<>("Registration Successful", null, HttpStatus.OK);
//        return ResponseEntity.ok(new String("User mood stored!"));
        return ResponseEntity.ok(new JwtResponse());

    }
}
