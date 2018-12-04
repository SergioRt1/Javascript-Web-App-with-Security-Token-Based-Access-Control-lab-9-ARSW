package com.example.lab9.controller;

import com.example.lab9.model.ApplicationUser;
import com.example.lab9.repository.ApplicationUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody ApplicationUser user) {
        if (applicationUserRepository.findById(user.getUsername()).isPresent()) {
            return new ResponseEntity<>("User already exists", HttpStatus.FORBIDDEN);
        } else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            applicationUserRepository.save(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
}