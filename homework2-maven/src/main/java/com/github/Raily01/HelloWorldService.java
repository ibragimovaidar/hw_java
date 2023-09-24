package com.github.Raily01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    private final String text;

    public HelloWorldService(@Value("${text}") String text) {
        this.text = text;
    }

    public String getHelloMessage() {
        return text;
    }
}
