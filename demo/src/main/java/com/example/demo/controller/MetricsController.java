package com.example.demo.controller;

import com.example.demo.service.MetricsService;
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
        model.addAttribute("successfulRequests", metricsService.getSuccessfulRequests());
        model.addAttribute("failedRequests", metricsService.getFailedRequests());
        return "metrics";
    }
}