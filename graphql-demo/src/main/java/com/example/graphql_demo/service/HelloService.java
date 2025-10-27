package com.example.graphql_demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String sayHello() {
        return "Hello, GraphQL!";
    }
}
