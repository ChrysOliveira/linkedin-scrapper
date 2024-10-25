package com.example.linkedin_scrapper;

import com.example.linkedin_scrapper.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


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