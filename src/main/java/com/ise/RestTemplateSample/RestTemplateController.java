package com.ise.RestTemplateSample;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class RestTemplateController {
    Logger log = LoggerFactory.getLogger(RestTemplateController.class);

    ExchangeSample exchangeSample = new ExchangeSample();

    @GetMapping("/hello")
    public void hello() {
        log.info("helloの実施");
        RestTemplateSampleEntity entity = new RestTemplateSampleEntity();
        exchangeSample.sendRequest(entity);
    }
}
