package com.example.doctorbackend.DoctorController;

import com.example.doctorbackend.model.GenerateLink;
import com.example.doctorbackend.service.LinkGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class LinkGeneration {

    @Autowired
    private LinkGenerationService linkGenerationService;

    @PostMapping("/generateLink")
    public ResponseEntity<?> generationOfLink(@RequestBody GenerateLink generateLink){
        if (linkGenerationService.emailIsExist(generateLink)==false){
            return ResponseEntity.badRequest().body(new GenerateLink("Email Already Exits!"));
//            "{\"Message\":Email Already Exist!}"
        }
        else{
            //code to send mail
            String values = generateLink.getDoctorId() + (':') + generateLink.getPatEmail() + (':') +
                            generateLink.getPatFname() + (':') + Long.toString(System.currentTimeMillis());
            String link =  "http://localhost:4200/register?add="+values;
            System.out.println(link);
            //send the link on required mailId
            return ResponseEntity.ok(new GenerateLink("Link Generated Successfully!"));
        }

    }

}
