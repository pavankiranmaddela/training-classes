package com.mpk.station.management.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class StationServiceConfig {

    @Value("${app.payment.gateway-url}")
    private String gatewayUrl;

    @Value("${app.payment.timeout-seconds:30}")
    private int timeoutSeconds;

    @Value("${app.payment.retry-attempts:3}")
    private int retryAttempts;

}
