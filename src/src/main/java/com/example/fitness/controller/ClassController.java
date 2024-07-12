package com.example.fitness.controller;

import com.example.fitness.entity.FitnessClass;
import com.example.fitness.repository.FitnessClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private FitnessClassRepository fitnessClassRepository;

    @PostMapping("/add")
    public FitnessClass addClass(@RequestBody FitnessClass fitnessClass) {
        return fitnessClassRepository.save(fitnessClass);
    }

    @GetMapping("/{id}")
    public FitnessClass getClassById(@PathVariable Long id) {
        FitnessClass fitnessClass = fitnessClassRepository.findById(id).orElse(null);
        if (fitnessClass == null) {
            throw new RuntimeException("Class not found");
        }
        return fitnessClass;
    }

    @GetMapping
    public List<FitnessClass> getAllClasses() {
        return fitnessClassRepository.findAll();
    }
}
