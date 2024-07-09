package com.example.demo.metrics;

import com.example.demo.service.MetricsService;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerMetricsAspect {

    private final MetricsService metricsService; // Замените MetricsService на ваш сервис метрик

    @Autowired
    public ControllerMetricsAspect(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @Pointcut("execution(* com.example.demo.controller.ClientController.*(..))")
    public void controllerExecution() {}

    @AfterReturning("controllerExecution()")
    public void logSuccessfulExecution() {
        metricsService.incrementSuccessfulRequests(); // Увеличить счётчик успешных запросов
    }

    @AfterThrowing("controllerExecution()")
    public void logExceptionOnExecution() {
        metricsService.incrementFailedRequests(); // Увеличить счётчик неуспешных запросов
    }
}