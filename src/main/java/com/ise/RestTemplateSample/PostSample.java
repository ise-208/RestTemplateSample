package com.ise.RestTemplateSample;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PostSample {
    RestTemplate restTemplate = new RestTemplate();

    RestTemplateSampleEntity entity;

    public ResponseEntity<String> sendExchangeRequest(RestTemplateSampleEntity entity) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> param = new HashMap<>();
        param.put("name", entity.getName());
        param.put("age", entity.getAge());
        param.put("id", entity.getId());
        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:8081/hello",
                HttpMethod.POST,
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
                "http://localhost:8081/hoge",
                HttpMethod.POST,
                requestCallback,
                response -> null,
                RestTemplateSampleEntity.class);

    }

    public void getRestTemplate() {
        RestTemplateResponse restTemplateResponse = new RestTemplateResponse();

        ResponseEntity<RestTemplateResponse> response = restTemplate.getForEntity(
                "url",
                RestTemplateResponse.class,
                restTemplateResponse
        );
        System.out.println(response.getBody());

    }
}
