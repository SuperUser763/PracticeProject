package com.example.pet.controller;

import com.example.pet.model.Owner;
import com.example.pet.model.Pet;
import com.example.pet.model.PetType;
import com.example.pet.service.OwnerService;
import com.example.pet.service.PetService;
import com.example.pet.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Optional;

@Controller
public class PetController {

    private final PetService petService;
    private final PetTypeService petTypeService;
    private final OwnerService ownerService;

    @Autowired
    public PetController(PetService petService, PetTypeService petTypeService, OwnerService ownerService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
    }

    @GetMapping("/addPet")
    public String addPetForm(Model model) {
        model.addAttribute("title", "Добавление нового питомца");
        return "add-pet";
    }

    @PostMapping("/addPet")
    public String addPet(@RequestParam Long petTypeID, @RequestParam Long ownerID,
                         @RequestParam String nickname, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDate,
                         @RequestParam String gender, Model model) {
        Optional<PetType> petTypeOpt = petTypeService.findById(petTypeID);
        Optional<Owner> ownerOpt = ownerService.findById(ownerID);

        if (!petTypeOpt.isPresent() || !ownerOpt.isPresent()) {
            model.addAttribute("message", "Тип питомца или владелец не найдены.");
            return "error";
        }

        Pet newPet = new Pet(petTypeOpt.get(), ownerOpt.get(), nickname, birthDate, gender);
        petService.addPet(newPet);
        model.addAttribute("message", "Новый питомец добавлен: " + newPet.getPetID() + "(ID)");
        return "result";
    }
}