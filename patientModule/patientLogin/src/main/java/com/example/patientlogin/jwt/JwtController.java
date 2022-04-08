package com.example.patientlogin.jwt;


import com.example.patientlogin.appuser.AppUser;
import com.example.patientlogin.appuser.AppUserRepository;
import com.example.patientlogin.appuser.AppUserService;
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

import java.util.Optional;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AppUserService appUserService;

//    @Autowired
//    private Doctor doctor; //added component to admin model

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AppUserRepository appUserRepository;


    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
    {
        System.out.println(jwtRequest);
        try
        {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));

        }catch(UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("Bad Credentials - username not found");
        }catch(BadCredentialsException e){
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }
        JwtResponse jwtResponse = new JwtResponse();



        UserDetails userDetails = this.appUserService.loadUserByUsername(jwtRequest.getEmail());
        Optional<AppUser> temp = appUserRepository.findByEmail(jwtRequest.getEmail());
        AppUser appUser = appUserRepository.searchEmail(jwtRequest.getEmail());

        System.out.println("Email is" + appUser.getEmail());
        System.out.println("First name is" + appUser.getFirstName());
        System.out.println("Last name is" + appUser.getLastName());
        System.out.println("Pat id is" + appUser.getId());
        System.out.println("password is" + appUser.getPassword());
//        System.out.println("Doc id is" + appUser.getDoc_id());


        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT token is "+token);

        jwtResponse.setToken(token);
        jwtResponse.setEmail(jwtRequest.getEmail());
        jwtResponse.setFname((appUser.getFirstName()));
        jwtResponse.setLname(appUser.getLastName());
        jwtResponse.setId(appUser.getId());

        return ResponseEntity.ok(jwtResponse);
    }
}

