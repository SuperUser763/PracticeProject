package com.example.pet.service;

import com.example.pet.model.Owner;
import com.example.pet.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public void addOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    public Optional<Owner> findById(Long id) {
        return ownerRepository.findById(id);
    }
}