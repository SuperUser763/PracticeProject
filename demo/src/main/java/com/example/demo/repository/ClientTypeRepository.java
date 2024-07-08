package com.example.demo.repository;

import com.example.demo.ClientType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientTypeRepository extends JpaRepository<ClientType, Long> {
    Optional<ClientType> findByClientTypeName(String clientTypeName);
}
