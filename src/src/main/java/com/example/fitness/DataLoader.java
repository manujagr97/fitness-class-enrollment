package com.example.fitness;

import com.example.fitness.entity.*;
import com.example.fitness.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private FitnessClassRepository fitnessClassRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void run(String... args) throws Exception {
        AppUser user1 = new AppUser("student1", "password1", "STUDENT");
        AppUser user2 = new AppUser("student2", "password2", "STUDENT");

        appUserRepository.save(user1);
        appUserRepository.save(user2);

        FitnessClass class1 = new FitnessClass("Yoga", "A relaxing yoga class", "Instructor1", "Monday 8 AM");
        FitnessClass class2 = new FitnessClass("Pilates", "A challenging pilates class", "Instructor2", "Wednesday 6 PM");

        fitnessClassRepository.save(class1);
        fitnessClassRepository.save(class2);

        Attendance attendance1 = new Attendance(user1, class1, "check", new Date(), "Present");
        Attendance attendance2 = new Attendance(user2, class2, "check", new Date(), "Absent");

        attendanceRepository.save(attendance1);
        attendanceRepository.save(attendance2);

        Payment payment1 = new Payment(user1, 100.0, "Paid", new Date());
        Payment payment2 = new Payment(user2, 150.0, "Pending", new Date());

        paymentRepository.save(payment1);
        paymentRepository.save(payment2);
    }
}
