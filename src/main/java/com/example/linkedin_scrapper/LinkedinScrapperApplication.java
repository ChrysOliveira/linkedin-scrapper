package com.example.linkedin_scrapper;

import com.example.linkedin_scrapper.services.EducationService;
import com.example.linkedin_scrapper.services.ExperienceService;
import com.example.linkedin_scrapper.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class LinkedinScrapperApplication {

    private final UserService userService;
    private final ExperienceService experienceService;
    private final EducationService educationService;

    public LinkedinScrapperApplication(UserService userService, ExperienceService experienceService, EducationService educationService) {
        this.userService = userService;
        this.experienceService = experienceService;
        this.educationService = educationService;
    }

    public static void main(String[] args) {
        SpringApplication.run(LinkedinScrapperApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            //userService.blabla();
            experienceService.requestExperience();
//            educationService.requestEducation();
        };
    }
}