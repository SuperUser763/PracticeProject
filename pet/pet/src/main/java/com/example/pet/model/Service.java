package com.example.pet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceID;

    @Column(nullable = false, length = 100)
    private String nameService;

    @Column(columnDefinition = "int default 0")
    private int price;

    public Service(){}

    public Service(String nameService, int price){
        this.nameService = nameService;
        this.price = price;
    }

    public Long getServiceID() {
        return serviceID;
    }

    public void setServiceID(Long serviceID) {
        this.serviceID = serviceID;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
