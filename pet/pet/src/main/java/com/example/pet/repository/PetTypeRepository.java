package com.example.pet.repository;

import com.example.pet.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends JpaRepository<PetType, Long> {
    PetType findByPetViewAndPetBreed(String petView, String petBreed);
}