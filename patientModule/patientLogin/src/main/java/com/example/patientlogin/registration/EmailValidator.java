package com.example.patientlogin.registration;

import com.example.patientlogin.appuser.AppUser;
import com.example.patientlogin.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Predicate;

@Service
@AllArgsConstructor
public class EmailValidator implements Predicate<String> {

    private final AppUserRepository appUserRepository;
    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    @Override
    public boolean test(String email)
    {
        Optional<AppUser> byEmail = appUserRepository.findByEmail(email);
        if(byEmail.isPresent())
            return false;
        return true;

//        byEmail
//                .orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email)));
    }

    public boolean isEmailPresent(String email) {
        Optional<AppUser> byEmail = appUserRepository.findByEmail(email);
        if(byEmail.isPresent())
            return true;
        return false;
    }
}
