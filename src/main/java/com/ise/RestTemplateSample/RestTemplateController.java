package com.ise.RestTemplateSample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class RestTemplateController {
    Logger log = LoggerFactory.getLogger(RestTemplateController.class);

    PostSample postSample = new PostSample();

    @GetMapping("/hello")
    public void hello() {
        log.info("helloの実施");
        RestTemplateSampleEntity entity = new RestTemplateSampleEntity();
        postSample.sendExchangeRequest(entity);
    }

    @GetMapping("/hoge")
    public void hoge() {
        log.info("hogeの実施");
        RestTemplateSampleEntity entity = new RestTemplateSampleEntity();
        postSample.sendExecuteRequest(entity);
    }
}
