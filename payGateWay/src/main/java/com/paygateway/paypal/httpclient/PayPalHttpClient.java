package com.paygateway.paypal.httpclient;

import java.net.URI;
import java.net.http.HttpClient.Version;

import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paygateway.paypal.config.PayPalEndpoints;
import com.paygateway.paypal.config.PaypalConfig;
import com.paygateway.paypal.dto.resp.AccessTokenResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PayPalHttpClient {
	private final HttpClient httpClient;
    private final PaypalConfig paypalConfig;
    private final ObjectMapper objectMapper;

    
    public PayPalHttpClient(PaypalConfig paypalConfig, ObjectMapper objectMapper) {
        this.paypalConfig = paypalConfig;
        this.objectMapper = objectMapper;
//        httpClient = new HttpClient().
        httpClient = (HttpClient) java.net.http.HttpClient.newBuilder()
//            .version(HttpClient.Version.HTTP_1_1)
        		.version(Version.HTTP_1_1)
        .build();
    }
    
    public AccessTokenResponseDTO getAccessToken() throws Exception {
 
    	var request = java.net.http.HttpRequest.newBuilder()
    		.uri(URI.create(PayPalEndpoints.createUrl("", PayPalEndpoints.GET_ACCESS_TOKEN)))
    		.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
    		.header(HttpHeaders.ACCEPT_LANGUAGE, "en_US")
    		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    		.POST(java.net.http.HttpRequest.BodyPublishers.ofString("grant_type=client_credentials"))
//    		.header(HttpHeaders.AUTHORIZATION, encodeBasicCredentials())
    		.build();
    	var response = ((java.net.http.HttpClient) httpClient).send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
        var content = response.body();
        return objectMapper.readValue(content, AccessTokenResponseDTO.class);
    	
    }
}
