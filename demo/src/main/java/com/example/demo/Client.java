package com.example.demo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(nullable = false, length = 100)
    private String fio;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(nullable = false, length = 10)
    private String gender;

    @ManyToOne
    @JoinColumn(name = "clientTypeId")
    private ClientType clientType;

    @Column(nullable = false, length = 20)
    private String phone;

    public Client() {}

    public Client(String fio, Date birthDate, String gender, ClientType clientType, String phone) {
        this.fio = fio;
        this.birthDate = birthDate;
        this.gender = gender;
        this.clientType = clientType;
        this.phone = phone;
    }

    // Getters and setters

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return fio;
    }

    public void setName(String name) {
        this.fio = name;
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

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
