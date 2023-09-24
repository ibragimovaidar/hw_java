package com.github.Raily01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SampleController {

    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
    private final HelloWorldService helloWorldService;

    public SampleController(@Autowired HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping
    public String helloWorld() {
        logger.info("Кто-то вызвал контроллер hello world на gradle");
        return helloWorldService.getHelloMessage();
    }
}
