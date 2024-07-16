package com.example.fitness.controller;

import com.example.fitness.entity.AuthRequest;
import com.example.fitness.entity.AppUser;
import com.example.fitness.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest authRequest) {
        AppUser user = new AppUser(authRequest.getUsername(), passwordEncoder.encode(authRequest.getPassword()), "RECEPTIONIST");
        appUserRepository.save(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        AppUser user = appUserRepository.findByUsername(authRequest.getUsername());
        if (user != null && passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
            return "Login successful";
        }
        return "Invalid username or password";
    }

    @GetMapping("users/{id}")
    public AppUser getUserById(@PathVariable Long id) {
        return appUserRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
