package com.mpk.station.management.config;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "app.payment")
@Configuration
@Validated
@Data
public class PaymentConfig {
    @NotBlank
    private String gatewayUrl;

    @Min(5) @Max(120)
    private int timeoutSeconds = 30;

    @Min(1) @Max(10)
    private int retryAttempts = 3;

}
