package com.example.linkedin_scrapper;

import com.example.linkedin_scrapper.services.UserService;
import com.example.linkedin_scrapper.utils.Utils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@SpringBootApplication
public class LinkedinScrapperApplication {

    private final UserService userService;

    public LinkedinScrapperApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(LinkedinScrapperApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            userService.blabla();
        };
    }
}