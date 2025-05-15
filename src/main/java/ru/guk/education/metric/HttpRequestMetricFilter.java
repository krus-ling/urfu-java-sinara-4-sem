package ru.guk.education.metric;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class HttpRequestMetricFilter implements Filter {

    private final Counter requestCounter;
    private final Timer requestTimer;

    private static final TimeUnit TIME_UNIT = TimeUnit.NANOSECONDS;

    public HttpRequestMetricFilter(MeterRegistry registry) {
        requestCounter = registry.counter("http_requests_total");
        requestTimer = registry.timer("http_requests_duration_seconds");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        requestCounter.increment();
        long start = System.nanoTime();

        try {
            chain.doFilter(request, response);
        } finally {
            long duration = System.nanoTime() - start;
            requestTimer.record(duration, TIME_UNIT);
        }
    }
}
