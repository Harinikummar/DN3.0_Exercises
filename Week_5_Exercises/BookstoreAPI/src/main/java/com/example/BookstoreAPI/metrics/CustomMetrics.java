package com.example.BookstoreAPI.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Counter;

public class CustomMetrics {

    private final Counter customCounter;

    public CustomMetrics(MeterRegistry meterRegistry) {
        this.customCounter = meterRegistry.counter("custom_metric", "type", "example");
    }

    public void incrementCustomCounter() {
        customCounter.increment();
    }
}
