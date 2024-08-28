package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.metrics.CustomMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class MetricsController {

    @Autowired
    private CustomMetrics customMetrics;

    @GetMapping("/increment")
    public String incrementMetric() {
        customMetrics.incrementCustomCounter();
        return "Custom metric incremented!";
    }
}

