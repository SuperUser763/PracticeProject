package com.example.pet.service;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class MetricsService {

    private final MeterRegistry meterRegistry;

    private final Timer successfulRequestsTimer;
    private final Timer failedRequestsTimer;

    @Autowired
    public MetricsService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;

        this.successfulRequestsTimer = Timer.builder("requests.success.time")
                .publishPercentiles(0.5, 0.95) // публикует медиану и 95-й процентиль
                .publishPercentileHistogram()
                .register(meterRegistry);

        this.failedRequestsTimer = Timer.builder("requests.failed.time")
                .publishPercentiles(0.5, 0.95)
                .publishPercentileHistogram()
                .register(meterRegistry);
    }

    public void recordSuccessfulRequestTime(long startTime) {
        long endTime = System.nanoTime();
        successfulRequestsTimer.record(endTime - startTime, TimeUnit.NANOSECONDS);
    }

    public void recordFailedRequestTime(long startTime) {
        long endTime = System.nanoTime();
        failedRequestsTimer.record(endTime - startTime, TimeUnit.NANOSECONDS);
    }

    public long getSuccessfulRequestsCount() {
        return successfulRequestsTimer.count();
    }

    public long getFailedRequestsCount() {
        return failedRequestsTimer.count();
    }
}
