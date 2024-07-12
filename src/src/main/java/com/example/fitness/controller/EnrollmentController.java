package com.example.fitness.controller;

import com.example.fitness.entity.Enrollment;
import com.example.fitness.entity.AppUser;
import com.example.fitness.entity.FitnessClass;
import com.example.fitness.repository.EnrollmentRepository;
import com.example.fitness.repository.AppUserRepository;
import com.example.fitness.repository.FitnessClassRepository;
import com.example.fitness.request.EnrollmentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private FitnessClassRepository fitnessClassRepository;

    @PostMapping
    public Enrollment enrollStudent(@RequestBody EnrollmentRequest enrollmentRequest) {
        AppUser student = appUserRepository.findById(enrollmentRequest.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        FitnessClass fitnessClass = fitnessClassRepository.findById(enrollmentRequest.getClassId())
                .orElseThrow(() -> new RuntimeException("Class not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setFitnessClass(fitnessClass);

        return enrollmentRepository.save(enrollment);
    }

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
}
