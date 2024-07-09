package com.example.pet.service;

import com.example.pet.model.Pet;
import com.example.pet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public void addPet(Pet pet) {
        petRepository.save(pet);
    }
}