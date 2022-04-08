package com.example.patientlogin.registration;

import com.example.patientlogin.appuser.AppUser;
import com.example.patientlogin.doctor.Doctor;
import com.example.patientlogin.doctor.DoctorDB;
import com.example.patientlogin.jwt.JwtResponse;
import com.example.patientlogin.jwt.JwtUtil;
import com.example.patientlogin.patient_progress.PatientProgress;
import com.example.patientlogin.patient_progress.PatientProgressRepo;
import com.example.patientlogin.patient_responses.PatientResponsesRequest;
import com.example.patientlogin.questions.QuestionsDB;
import com.example.patientlogin.section.Section;
import com.example.patientlogin.section.SectionRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RestController
//@RequestMapping(path = "")
@AllArgsConstructor
@CrossOrigin(origins ="http://localhost:4200/")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final QuestionsDB questionsDB;
    private final DoctorDB doctorDB;
    private final SectionRepo sectionRepo;
    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;
    private final PatientProgressRepo patientProgressRepo;

//    @PostMapping(path = "patient/responses")
//    public String storeResponses(@RequestBody PatientResponsesRequest patientResponsesRequest)
//    {
////        long pat_id = 1;
//        System.out.println("THe link is working");
////        patientResponsesService.saveResponses(patientResponsesRequest,pat_id);
//        //@RequestBody PatientResponsesRequest patientResponsesRequest
//        return "User responses stored!";
//    }

    @GetMapping(path = "addQuestions")
    public void addQuestions()
    {
        questionsDB.addQuestions();
        doctorDB.addDoctor();
    }

    @PostMapping(path = "register")
    public AppUser register(@RequestBody RegistrationRequest request)
            throws MessagingException, UnsupportedEncodingException
    {

        Doctor doctor = doctorDB.getDoctor(1L);

        AppUser appUser = registrationService.register(request,doctor);

//        PatientProgress patientProgress = new PatientProgress();
//        patientProgress.setSection(sectionRepo.getById(0L));
//        patientProgress.setAppUser(appUser);
//
//        patientProgressRepo.save(patientProgress);

        return appUser;
    }
    // The below path "conform" must match with the "link" which we send to the email.
    //
    @GetMapping(path = "conform")
    public String confirmation(@RequestParam String token)
    {
        System.out.println("token extracted from the URL is " + token);
        return registrationService.confirmToken(token);
    }


    //return for this method was ResponseEntity<UserDetails> until JWT was implemented
//    @PostMapping(path = "login")
//    public  ResponseEntity<?> login(@RequestBody RegistrationRequest request) throws Exception
//    {
////        try {
////            authenticationManager.authenticate(
////                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
////            );
////        }
////        catch (Exception e)
////        {
////            throw new Exception("INvalid email/password");
////        }
////        String authToken = jwtUtil.generateToken();
//        registrationService.login(request);
//        return ResponseEntity.ok("new token not created!");
////        return authToken;
//    }
}
