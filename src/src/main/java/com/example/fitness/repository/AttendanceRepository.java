package com.example.fitness.repository;

import com.example.fitness.entity.Attendance;
import com.example.fitness.entity.FitnessClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByFitnessClass(FitnessClass fitnessClass);
}
