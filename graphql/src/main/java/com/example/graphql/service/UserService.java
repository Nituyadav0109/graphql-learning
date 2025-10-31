package com.example.graphql.service;

import com.example.graphql.model.User;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    private final Map<String, User> userStore = new ConcurrentHashMap<>();

    public User getUser(String id) {
        return userStore.get(id);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userStore.values());
    }

    public User createUser(String name, String email) {
        String id = UUID.randomUUID().toString();
        User user = new User(id, name, email);
        userStore.put(id, user);
        return user;
    }
}
