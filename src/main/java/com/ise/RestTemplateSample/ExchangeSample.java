package com.ise.RestTemplateSample;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExchangeSample {
    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<String> request = new HttpEntity<>(new String());

    ResponseEntity<String> response = restTemplate.exchange(null, HttpMethod.GET, request, String.class);

}
