package com.ise.RestTemplateSample;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class ExchangeSample {
    RestTemplate restTemplate = new RestTemplate();
    public ResponseEntity<String> sendRequest(RestTemplateSampleEntity entity){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);


        Map<String, Object> param = new HashMap<>();
        param.put("name", entity.getName());
        param.put("age", entity.getAge());
        param.put("id", entity.getId());
        ResponseEntity<String> response = restTemplate.exchange(
                "url",
                HttpMethod.GET,
                new HttpEntity<>(param, httpHeaders),
                String.class);

        return response;
    }
}
