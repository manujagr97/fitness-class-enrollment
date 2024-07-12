package com.example.fitness.repository;

import com.example.fitness.entity.Payment;
import com.example.fitness.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByUser(AppUser user);
}
