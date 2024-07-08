package com.example.demo.service;

import com.example.demo.ClientType;
import com.example.demo.repository.ClientTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientTypeService {

    private final ClientTypeRepository clientTypeRepository;

    public ClientTypeService(ClientTypeRepository clientTypeRepository) {
        this.clientTypeRepository = clientTypeRepository;
    }

    public void addClientType(String name) {
        ClientType type = new ClientType(name);
        clientTypeRepository.save(type);
    }

    public Optional<ClientType> getClientTypeByName(String name) {
        return clientTypeRepository.findByClientTypeName(name);
    }
}