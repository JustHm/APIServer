package com.justhm.APIServer.controller;

import com.justhm.APIServer.model.LoginRequest;
import com.justhm.APIServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MainController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String firstEnter() {
        return "Hello";
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody LoginRequest loginRequest) {
        if (userRepository.findByUsername(loginRequest.getUsername()).isPresent()) {
            return "userName is exist..";
        }
        userRepository.save(loginRequest);
        return "complete";
    }
    @PostMapping("/signin")
    public String signIn(@RequestBody LoginRequest loginRequest) {
        Optional<LoginRequest> user = userRepository.findByUsername(loginRequest.getUsername());
        if (user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword())) {
            return "Success";
        }
        return "Failed";
    }
}
