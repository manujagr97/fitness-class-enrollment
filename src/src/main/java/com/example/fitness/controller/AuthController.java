package com.example.fitness.controller;

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
    public AppUser register(@RequestBody AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return appUserRepository.save(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody AppUser user) {
        AppUser existingUser = appUserRepository.findByUsername(user.getUsername());
        if (existingUser != null && passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            return "User logged in successfully!";
        } else {
            return "Invalid username or password!";
        }
    }
}
