package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MetricsService {

    private long successfulRequests = 0;
    private long failedRequests = 0;

    public void incrementSuccessfulRequests() {
        successfulRequests++;
    }

    public void incrementFailedRequests() {
        failedRequests++;
    }

    public long getSuccessfulRequests() {
        return successfulRequests;
    }

    public long getFailedRequests() {
        return failedRequests;
    }
}