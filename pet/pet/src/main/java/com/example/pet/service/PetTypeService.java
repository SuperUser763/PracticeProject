package com.example.pet.service;

import com.example.pet.model.PetType;
import com.example.pet.repository.PetTypeRepository;
import com.example.pet.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetTypeService {

    private final PetTypeRepository petTypeRepository;
    private final MetricsService metricsService;

    @Autowired
    public PetTypeService(PetTypeRepository petTypeRepository, MetricsService metricsService) {
        this.petTypeRepository = petTypeRepository;
        this.metricsService = metricsService;
    }

    public void addPetType(PetType petType) {
        long startTime = System.nanoTime();
        try {
            petTypeRepository.save(petType);
            long duration = System.nanoTime() - startTime;
            metricsService.recordSuccessfulRequestTime(duration);
        } catch (Exception e) {
            long duration = System.nanoTime() - startTime;
            metricsService.recordFailedRequestTime(duration);
            throw e;
        }
    }

    public PetType findPetTypeByViewAndBreed(String petView, String petBreed) {
        long startTime = System.nanoTime();
        try {
            PetType petType = petTypeRepository.findByPetViewAndPetBreed(petView, petBreed);
            long duration = System.nanoTime() - startTime;
            metricsService.recordSuccessfulRequestTime(duration);
            return petType;
        } catch (Exception e) {
            long duration = System.nanoTime() - startTime;
            metricsService.recordFailedRequestTime(duration);
            throw e;
        }
    }

    public Optional<PetType> findById(Long id) {
        long startTime = System.nanoTime();
        try {
            Optional<PetType> petType = petTypeRepository.findById(id);
            long duration = System.nanoTime() - startTime;
            metricsService.recordSuccessfulRequestTime(duration);
            return petType;
        } catch (Exception e) {
            long duration = System.nanoTime() - startTime;
            metricsService.recordFailedRequestTime(duration);
            throw e;
        }
    }
}
