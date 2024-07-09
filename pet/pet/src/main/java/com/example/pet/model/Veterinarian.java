package com.example.pet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Veterinarian")
public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long veterinarianID;

    @Column(nullable = false, length = 100)
    private String specialization;

    public Veterinarian(){}

    public Veterinarian(String specialization){
        this.specialization = specialization;
    }

    public Long getVeterinarianID() {
        return veterinarianID;
    }

    public void setVeterinarianID(Long veterinarianID) {
        this.veterinarianID = veterinarianID;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
