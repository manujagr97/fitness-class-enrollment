package com.example.fitness.controller;

import com.example.fitness.entity.Payment;
import com.example.fitness.entity.AppUser;
import com.example.fitness.repository.PaymentRepository;
import com.example.fitness.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @PostMapping("/make")
    public Payment addPayment(@RequestBody Payment payment) {
        AppUser student = appUserRepository.findById(payment.getUser().getId()).orElse(null);
        if (student == null) {
            throw new RuntimeException("Student not found");
        }
        payment.setUser(student);
        return paymentRepository.save(payment);
    }

    @GetMapping("/{studentId}")
    public List<Payment> getPaymentsByStudent(@PathVariable Long studentId) {
        AppUser student = appUserRepository.findById(studentId).orElse(null);
        if (student == null) {
            throw new RuntimeException("Student not found");
        }
        return paymentRepository.findByUser(student);
    }
}
