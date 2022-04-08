package com.example.doctorbackend.jwt.service;

import com.example.doctorbackend.model.CustomUserDetails;
import com.example.doctorbackend.model.Doctor;
import com.example.doctorbackend.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

//    @Autowired
//    private DoctorRepository doctorRepository;
//
//    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //user from database
//        Doctor doctor = this.doctorRepository.findByUsername(username);
//        if (doctor==null){
//            throw new UsernameNotFoundException("Admin Not Found!");
//        }
//        else{
//            return new CustomUserDetails(doctor);
//        }


        if(username.equals("doctor"))
            return new User("doctor", "admin", new ArrayList<>());
        else{
            throw new UsernameNotFoundException("User Not found");
        }
    }
}
