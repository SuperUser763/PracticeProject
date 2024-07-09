package com.example.pet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Owner")
public class Owner {

    @Id
    private Long ownerID;

    @Column
    private Long clientID;

    public Owner() {}

    public Owner(Long ownerID, Long clientID){
        this.ownerID = ownerID;
        this.clientID = clientID;
    }

    public Long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Long ownerID) {
        this.ownerID = ownerID;
    }

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }
}