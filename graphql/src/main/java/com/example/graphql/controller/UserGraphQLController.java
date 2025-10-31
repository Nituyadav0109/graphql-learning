package com.example.graphql.controller;

import com.example.graphql.model.User;
import com.example.graphql.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserGraphQLController {

    private final UserService userService;

    public UserGraphQLController(UserService userService) {
        this.userService = userService;
    }

    // ✅ hello
    @QueryMapping
    public String hello() {
        return "Hello from Spring Boot GraphQL!";
    }

    // ✅ helloUser(name: String!)
    @QueryMapping
    public String helloUser(@Argument String name) {
        return "Hello, " + name + "! Welcome to GraphQL.";
    }

    // ✅ getUser(id: ID!)
    @QueryMapping
    public User getUser(@Argument String id) {
        return userService.getUser(id);
    }

    // ✅ getAllUsers
    @QueryMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // ✅ createUser(name: String!, email: String!)
    @MutationMapping
    public User createUser(@Argument String name, @Argument String email) {
        return userService.createUser(name, email);
    }
}
