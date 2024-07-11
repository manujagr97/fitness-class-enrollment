package com.example.fitness;

import com.example.fitness.entity.AppUser;
import com.example.fitness.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner loadData() {
        return args -> {
            if (appUserRepository.count() == 0) {
                appUserRepository.save(new AppUser("user1", passwordEncoder.encode("password1")));
                appUserRepository.save(new AppUser("user2", passwordEncoder.encode("password2")));
                appUserRepository.save(new AppUser("user3", passwordEncoder.encode("password3")));
                appUserRepository.save(new AppUser("user4", passwordEncoder.encode("password4")));
                appUserRepository.save(new AppUser("user5", passwordEncoder.encode("password5")));
                appUserRepository.save(new AppUser("user6", passwordEncoder.encode("password6")));
                appUserRepository.save(new AppUser("user7", passwordEncoder.encode("password7")));
                appUserRepository.save(new AppUser("user8", passwordEncoder.encode("password8")));
                appUserRepository.save(new AppUser("user9", passwordEncoder.encode("password9")));
                appUserRepository.save(new AppUser("user10", passwordEncoder.encode("password10")));
            }
        };
    }
}
