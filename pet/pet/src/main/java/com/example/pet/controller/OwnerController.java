package com.example.pet.controller;

import com.example.pet.model.Owner;
import com.example.pet.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/addOwner")
    public String addOwnerForm(Model model) {
        model.addAttribute("title", "Добавление нового владельца");
        return "add-owner";
    }

    @PostMapping("/addOwner")
    public String addOwner(@RequestParam Long ownerID, @RequestParam Long clientID, Model model) {
        Owner newOwner = new Owner(ownerID, clientID);
        ownerService.addOwner(newOwner);
        model.addAttribute("message", "Новый владелец добавлен: " + newOwner.getOwnerID() + "(ID)");
        return "result";
    }
}
