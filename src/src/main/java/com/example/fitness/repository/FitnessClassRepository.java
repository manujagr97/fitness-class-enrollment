package com.example.fitness.repository;

import com.example.fitness.entity.FitnessClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FitnessClassRepository extends JpaRepository<FitnessClass, Long> {
    FitnessClass findByName(String name);
}
