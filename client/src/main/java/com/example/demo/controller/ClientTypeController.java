package com.example.demo.controller;

import com.example.demo.ClientType;
import com.example.demo.service.ClientTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ClientTypeController {

    private final ClientTypeService clientTypeService;

    @Autowired
    public ClientTypeController(ClientTypeService clientTypeService) {
        this.clientTypeService = clientTypeService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Main Page");
        return "home";
    }

    @GetMapping("/addType")
    public String addType(Model model) {
        return "add-type";
    }

    @PostMapping("/addType")
    public String addTypePost(@RequestParam String nameType,Model model){
        clientTypeService.addClientType(nameType);
        return "redirect:/home";
    }

    @GetMapping("/getType")
    public String getType(Model model) {
        return "get-type";
    }

    @PostMapping("/getType")
    public String getTypePost(@RequestParam String nameType, Model model) {
        Optional<ClientType> clientTypeOpt = clientTypeService.getClientTypeByName(nameType);
        if (clientTypeOpt.isPresent()) {
            ClientType clientType = clientTypeOpt.get();
            model.addAttribute("message", "Client Type ID: " + clientType.getClientTypeID());
        } else {
            model.addAttribute("message", "Client Type not found");
        }
        return "result";
    }


}