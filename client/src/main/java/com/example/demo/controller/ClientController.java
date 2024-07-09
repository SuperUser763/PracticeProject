package com.example.demo.controller;

import com.example.demo.Client;
import com.example.demo.ClientType;
import com.example.demo.service.ClientService;
import com.example.demo.service.ClientTypeService;
import com.example.demo.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Optional;

@Controller
public class ClientController {

    private final ClientService clientService;
    private final ClientTypeService clientTypeService;
    private final MetricsService metricsService; // Внедрите MetricsService

    @Autowired
    public ClientController(ClientService clientService, ClientTypeService clientTypeService, MetricsService metricsService) {
        this.clientService = clientService;
        this.clientTypeService = clientTypeService;
        this.metricsService = metricsService;
    }

    @GetMapping("/addClient")
    public String addClientForm() {
        return "add-client";
    }

    @PostMapping("/addClient")
    public String addClient(@RequestParam String fio, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDate, @RequestParam String gender,
                            @RequestParam Long clientTypeId, @RequestParam String phone, Model model) {
        try {
            // Получаем ClientType по его ID
            Optional<ClientType> clientTypeOptional = clientTypeService.getClientTypeById(clientTypeId);
            if (!clientTypeOptional.isPresent()) {
                model.addAttribute("message", "Client type not found.");
                return "error";
            }

            ClientType clientType = clientTypeOptional.get();
            Client newClient = clientService.addClient(fio, birthDate, gender, clientType, phone);
            model.addAttribute("message", "New client added: " + newClient.getClientId() + "(ID)");

            // Увеличиваем счётчик успешных запросов
            metricsService.incrementSuccessfulRequests();

            return "result";
        } catch (Exception e) {
            // Логирование ошибки
            model.addAttribute("message", "Error occurred: " + e.getMessage());

            // Увеличиваем счётчик неуспешных запросов
            metricsService.incrementFailedRequests();

            return "error";
        }
    }

    @GetMapping("/countClientsByGender")
    public String countClientsByGenderForm() {
        return "count-clients-by-gender";
    }

    @PostMapping("/countClientsByGender")
    public String countClientsByGender(@RequestParam String gender, Model model) {
        try {
            long count = clientService.countClientsByGender(gender);
            model.addAttribute("count", count);
            model.addAttribute("gender", gender);

            // Увеличиваем счётчик успешных запросов
            metricsService.incrementSuccessfulRequests();

            return "count-clients-by-gender-result";
        } catch (Exception e) {
            // Логирование ошибки
            model.addAttribute("message", "Error occurred: " + e.getMessage());

            // Увеличиваем счётчик неуспешных запросов
            metricsService.incrementFailedRequests();

            return "error";
        }
    }
}