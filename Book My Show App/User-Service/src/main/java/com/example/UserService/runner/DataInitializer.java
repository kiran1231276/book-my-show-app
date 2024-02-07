package com.example.UserService.runner;

import com.example.UserService.entity.User;
import com.example.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {
   @Autowired
    private UserRepository userRepository;
   @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User();
        u1.setUserId(UUID.randomUUID().toString());
        u1.setFName("kiran vighne");
        u1.setEmail("kiran123@gmail.com");
        u1.setUserName("kiran123");
        u1.setDob(LocalDate.parse("1997-02-17"));
        u1.setPassword(passwordEncoder.encode("kiran@123"));

        // userRepository.save(u1);

    }
}
