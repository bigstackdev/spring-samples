package dev.bigstack.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.bigstack.config.DemoConfigProperties;

@RestController
public class DemoRestController {

    @Autowired
    private DemoConfigProperties demoConfigProperties;

    @GetMapping("/health")
    public String health() {
        return HttpStatus.OK.name();
    }

    @GetMapping("/app-configs")
    public String getConfigs() {
        return demoConfigProperties.toString();
    }
}
