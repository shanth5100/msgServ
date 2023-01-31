package com.paygateway.paypal.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import jakarta.validation.constraints.NotEmpty;

@Configuration
@ConfigurationProperties(prefix = "paypal")
public class PaypalConfig {

	@NotEmpty
    private String baseUrl;
    @NotEmpty
    private String clientId;
    @NotEmpty
    private String secret;
}
