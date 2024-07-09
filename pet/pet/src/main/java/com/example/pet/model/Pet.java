package com.example.pet.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petID;

    @ManyToOne
    @JoinColumn(name = "petTypeID", nullable = false)
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "ownerID", nullable = false)
    private Owner owner;

    @Column(nullable = false, length = 100)
    private String nickname;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(nullable = false, length = 10)
    private String gender;


    public Pet() {}

    public Pet(PetType petType, Owner owner, String nickname,Date birthDate, String gender) {
        this.petType = petType;
        this.owner = owner;
        this.nickname = nickname;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Long getPetID() {
        return petID;
    }

    public void setPetID(Long petID) {
        this.petID = petID;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
