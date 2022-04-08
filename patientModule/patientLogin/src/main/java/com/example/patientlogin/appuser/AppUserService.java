package com.example.patientlogin.appuser;

import com.example.patientlogin.doctor.Doctor;
import com.example.patientlogin.registration.token.ConfirmationToken;
import com.example.patientlogin.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JavaMailSender mailSender;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AppUser> byEmail = appUserRepository.findByEmail(email);

        return byEmail
                .orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email)));
    }

    public AppUser signUpUser(AppUser appUser, Doctor doctor) throws MessagingException, UnsupportedEncodingException {
        boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();

        if(userExists)
        {
            //TODO: check attributes of the user and if they are the same
            //TODO: and if the time of token has expired, then resend the mail again
           throw new IllegalStateException("Email already exists.. try logging in maybe!");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);
        appUser.setDoctor(doctor);
        appUserRepository.save(appUser);

//        //Done: send confirmation token
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(5),
                appUser
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        String link = "http://localhost:8080/conform?token=" + token;
        sendOTPEmail(appUser, link);
        return appUser;
//        return "signup success";
    }

    public void sendOTPEmail(AppUser appUser, String link)
            throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("patient@healthcare.com", "Depression Support");
        helper.setTo(appUser.getEmail());

        String subject = "Here's your One Time Password (OTP) - Expire in 5 minutes!";

        String content = "<p>Hello " + appUser.getFirstName() + "</p>"
                + "<p>For security reason, you're required to use the following "
                + "One Time Password to login:</p>"
                + "<p><b>" + link + "</b></p>"
                + "<br>"
                + "<p>Note: this OTP is set to expire in 5 minutes.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }

}