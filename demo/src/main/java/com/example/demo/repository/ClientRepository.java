package com.example.demo.repository;

import com.example.demo.Client;
import com.example.demo.ClientType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByFio(String fio);
    long countByGender(String gender);
}