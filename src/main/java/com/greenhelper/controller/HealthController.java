package com.greenhelper.controller;

import com.greenhelper.dto.HealthResponse;
import com.greenhelper.service.HealthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping("/api/healthCheck")
    public HealthResponse healthCheck() {
        return new HealthResponse(
                healthService.getApplicationStatus(),
                healthService.getApplicationTime(),
                healthService.getDatabaseStatus(),
                healthService.getDatabaseTime());
    }
}
