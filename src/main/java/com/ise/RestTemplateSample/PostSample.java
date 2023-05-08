package com.ise.RestTemplateSample;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostSample {
    RestTemplate restTemplate = new RestTemplate();

    RestTemplateSampleEntity entity;

    public ResponseEntity<String> sendExchangeRequest(RestTemplateSampleEntity entity){
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

    public void sendExecuteRequest(RestTemplateSampleEntity entity) {
        Map<String, Object> param = new HashMap<>();

        RequestCallback requestCallback = request -> {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(request.getBody(), entity);
            request.getHeaders().setAccept(Arrays.asList(
                    MediaType.APPLICATION_JSON,
                    MediaType.ALL));
        };


        restTemplate.execute(
                "url",
                HttpMethod.GET,
                requestCallback,
                response -> null,
                RestTemplateSampleEntity.class);
    }
}
