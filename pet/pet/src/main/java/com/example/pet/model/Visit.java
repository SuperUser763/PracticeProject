package com.example.pet.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Visit")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visitID;

    @Id
    @ManyToOne
    @JoinColumn(name = "petID", nullable = false)
    private Pet pet;

    @Column(nullable = false, length = 100)
    private String visitGoal;

    @ManyToOne
    @JoinColumn(name = "serviceID", nullable = false)
    private Service service;

    @ManyToOne
    @JoinColumn(name = "veterinarianID", nullable = false)
    private Veterinarian veterinarian;

    @Temporal(TemporalType.DATE)
    private Date visitDate;

    public Visit(){}

    public Visit(Pet pet, String visitGoal, Service service, Veterinarian veterinarian, Date visitDate){
        this.pet = pet;
        this.visitGoal = visitGoal;
        this.service = service;
        this.veterinarian = veterinarian;
        this.visitDate = visitDate;
    }

    public Long getVisitID() {
        return visitID;
    }

    public void setVisitID(Long visitID) {
        this.visitID = visitID;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getVisitGoal() {
        return visitGoal;
    }

    public void setVisitGoal(String visitGoal) {
        this.visitGoal = visitGoal;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
}

