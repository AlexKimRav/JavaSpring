package com.example.javaspring;

import com.example.javaspring.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class JavaSpringApplication {
    public static void main(String[] args) {

        SpringApplication.run(JavaSpringApplication.class, args);

    }
}
