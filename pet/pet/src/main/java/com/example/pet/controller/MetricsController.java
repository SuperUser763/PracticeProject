package com.example.pet.controller;

import com.example.pet.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MetricsController {

    private final MetricsService metricsService;

    @Autowired
    public MetricsController(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @GetMapping("/metrics")
    public String showMetrics(Model model) {
        long successfulRequests = metricsService.getSuccessfulRequestsCount();
        long failedRequests = metricsService.getFailedRequestsCount();

        model.addAttribute("successfulRequests", successfulRequests);
        model.addAttribute("failedRequests", failedRequests);

        return "metrics";
    }
}
