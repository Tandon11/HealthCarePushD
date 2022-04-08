package com.example.doctorbackend.DoctorController;

import com.example.doctorbackend.jwt.service.CustomUserDetailsService;
import com.example.doctorbackend.jwt.util.JwtUtil;
import com.example.doctorbackend.model.Doctor;

import com.example.doctorbackend.model.JwtRequest;
import com.example.doctorbackend.model.JwtResponse;
import com.example.doctorbackend.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private DoctorRepository doctorRepository;

//    @Autowired
//    private Doctor doctor; //added component to admin model

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.println(jwtRequest);
        try
        {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

        }catch(UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("Bad Credentials - username not found");
        }catch(BadCredentialsException e){
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }

        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT token is "+token);

        JwtResponse jwtResponse = new JwtResponse();
        System.out.println(jwtRequest.getUsername());
        Doctor doctor = doctorRepository.findByUsername(jwtRequest.getUsername());


        System.out.println(doctor.getUsername());
        jwtResponse.setToken(token);
        jwtResponse.setFname(doctor.getFname());
        jwtResponse.setLname(doctor.getLname());
        jwtResponse.setUsername(doctor.getUsername());
        jwtResponse.setId(doctor.getId());
        jwtResponse.setIsAvail(doctor.getIs_Avail());
        return ResponseEntity.ok(jwtResponse);
    }
}
