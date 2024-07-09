package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "AddressType")
public class AddressType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressTypeId;

    @Column(nullable = false, length = 100)
    private String addressTypeName;

    // Getters and setters
    public Long getAddressTypeId() {
        return addressTypeId;
    }

    public void setAddressTypeId(Long addressTypeId) {
        this.addressTypeId = addressTypeId;
    }

    public String getAddressTypeName() {
        return addressTypeName;
    }

    public void setAddressTypeName(String addressTypeName) {
        this.addressTypeName = addressTypeName;
    }
}