package com.example.pet.controller;

import com.example.pet.model.PetType;
import com.example.pet.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PetTypeController {

    private final PetTypeService petTypeService;

    @Autowired
    public PetTypeController(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @GetMapping("/addPetType")
    public String addPetTypeForm(Model model) {
        model.addAttribute("title", "Добавление нового типа питомца");
        return "add-pettype";
    }

    @PostMapping("/addPetType")
    public String addPetType(@RequestParam String petView, @RequestParam String petBreed, Model model) {
        PetType newPetType = new PetType(petView, petBreed);
        petTypeService.addPetType(newPetType);
        model.addAttribute("message", "Новый тип питомца добавлен: " + newPetType.getPetTypeID() + "(ID)");
        return "result";
    }

    @GetMapping("/getPetType")
    public String getPetTypeForm(Model model) {
        model.addAttribute("title", "Поиск типа питомца");
        return "get-pettype";
    }

    @PostMapping("/getPetType")
    public String getPetType(@RequestParam String petView, @RequestParam String petBreed, Model model) {
        PetType petType = petTypeService.findPetTypeByViewAndBreed(petView, petBreed);
        if (petType != null) {
            model.addAttribute("message", "ID типа питомца: " + petType.getPetTypeID());
        } else {
            model.addAttribute("message", "Тип питомца не найден");
        }
        return "result";
    }
}
