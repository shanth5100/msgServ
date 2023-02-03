package com.paygateway.paypal.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

import jakarta.validation.constraints.NotEmpty;

@Configuration
@ConfigurationProperties(prefix = "paypal")
public class PaypalConfig {

	@NotEmpty
    private String baseUrl;
    @NotEmpty
    @Value("AYSq3RDGsmBLJE-otTkBtM")
    private String clientId;
    @NotEmpty
    @Value("AYSq3RDGsmBLJE-otTkBtM")
    private String secret;
        
    @Value("sandbox")
    private String mode;

    @Bean
    Map<String, String> paypalSdkConfig() {
        Map<String, String> configMap = new HashMap<>();
        configMap.put("mode", mode);
        return configMap;
    }

    @Bean
    OAuthTokenCredential oAuthTokenCredential() {
        return new OAuthTokenCredential(clientId, secret, paypalSdkConfig());
    }

    @SuppressWarnings("deprecation")
    @Bean
    APIContext apiContext() throws PayPalRESTException {
        APIContext context = new APIContext(oAuthTokenCredential().getAccessToken());
        context.setConfigurationMap(paypalSdkConfig());
        return context;

    }
    
}
