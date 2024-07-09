package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "ClientType")
public class ClientType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientTypeID;

    @Column(nullable = false, length = 100)
    private String clientTypeName;

    public ClientType() {};

    public ClientType(String clientTypeName) {this.clientTypeName = clientTypeName;}

    public Long getClientTypeID() {
        return clientTypeID;
    }

    public void setClientTypeID(Long clientTypeID) {
        this.clientTypeID = clientTypeID;
    }

    public String getClientTypeName() {
        return clientTypeName;
    }

    public void setClientTypeName(String clientTypeName) {
        this.clientTypeName = clientTypeName;
    }

}