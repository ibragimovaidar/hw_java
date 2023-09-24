package com.github.raily01.homework2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    private final String name;

    public HelloWorldService(@Value("${name:World}") String name) {
        this.name = name;
    }

    public String getHelloMessage() {
        return String.format("Hello %s!", name);
    }
}
