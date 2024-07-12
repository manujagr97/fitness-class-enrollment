package com.example.fitness.controller;

import com.example.fitness.entity.Attendance;
import com.example.fitness.entity.FitnessClass;
import com.example.fitness.entity.AppUser;
import com.example.fitness.repository.AttendanceRepository;
import com.example.fitness.repository.FitnessClassRepository;
import com.example.fitness.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private FitnessClassRepository fitnessClassRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @PostMapping("/mark")
    public Attendance markAttendance(@RequestBody Attendance attendance) {
        AppUser student = appUserRepository.findById(attendance.getUser().getId()).orElse(null);
        FitnessClass fitnessClass = fitnessClassRepository.findById(attendance.getFitnessClass().getId()).orElse(null);

        if (student == null) {
            throw new RuntimeException("Student not found");
        }
        if (fitnessClass == null) {
            throw new RuntimeException("Class not found");
        }

        attendance.setUser(student);
        attendance.setFitnessClass(fitnessClass);
        attendance.setDate(new Date()); // Assuming the attendance is marked for the current date
        return attendanceRepository.save(attendance);
    }

    @GetMapping("/{classId}")
    public List<Attendance> getAttendanceByClass(@PathVariable Long classId) {
        FitnessClass fitnessClass = fitnessClassRepository.findById(classId).orElse(null);
        if (fitnessClass == null) {
            throw new RuntimeException("Class not found");
        }
        return attendanceRepository.findByFitnessClass(fitnessClass);
    }
}
