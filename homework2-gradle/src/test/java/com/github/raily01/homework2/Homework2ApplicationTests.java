package com.github.raily01.homework2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {HelloWorldService.class, SampleController.class}, properties = "name=Railya")
class Homework2ApplicationTests {


    @Autowired
    private SampleController sampleController;

    @Autowired
    private HelloWorldService helloWorldService;

    @Autowired
    private Environment environment;

    @Test
    void contextLoads() {
        assertThat(sampleController)
                .as("Контроллер должен быть доступен из контекста спринга")
                .isNotNull();
    }

    @Test
    void controllerTest() {
        assertThat(sampleController.helloWorld())
                .as("значение контроллера и сервиса должны совпадать")
                .isEqualTo(helloWorldService.getHelloMessage());
    }

    @Test
    void serviceTest() {
        assertThat(helloWorldService.getHelloMessage())
                .as("Сервис должен вернуть ожидаемую строку")
                .isEqualTo(environment.getProperty("text"));
    }

}
