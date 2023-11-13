package com.example.javaspring.controllers;

import com.example.javaspring.Service.UserService;
import com.example.javaspring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HelloController {
    private final UserService userService;
    @Autowired
    public HelloController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/hello")
    public String index() {
        return "Hello from Spring Boot";
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/getUser")
    public Optional<User> getUser(@RequestParam Long id) {
        return userService.findById(id);
    }
}
