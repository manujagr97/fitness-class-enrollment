package com.example.fitness.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private AppUser user;
    @ManyToOne
    private FitnessClass fitnessClass;
    private String status;
    private Date date;
    private String notes;

    public Attendance() {}

    public Attendance(AppUser user, FitnessClass fitnessClass, String status, Date date, String notes) {
        this.user = user;
        this.fitnessClass = fitnessClass;
        this.status = status;
        this.date = date;
        this.notes = notes;
    }

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public FitnessClass getFitnessClass() {
        return fitnessClass;
    }

    public void setFitnessClass(FitnessClass fitnessClass) {
        this.fitnessClass = fitnessClass;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
