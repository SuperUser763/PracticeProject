package com.example.pet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PetType")
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petTypeID;

    @Column(nullable = false, length = 100)
    private String petView;

    @Column(nullable = false, length = 100)
    private String petBreed;

    public PetType(){}

    public PetType(String petView, String petBreed){
        this.petView = petView;
        this.petBreed = petBreed;

    }

    public Long getPetTypeID() {
        return petTypeID;
    }

    public void setPetTypeID(Long petTypeID) {
        this.petTypeID = petTypeID;
    }

    public String getPetView() {
        return petView;
    }

    public void setPetView(String petView) {
        this.petView = petView;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }
}
