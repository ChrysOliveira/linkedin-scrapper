package com.example.linkedin_scrapper;

import com.example.linkedin_scrapper.domains.entities.UserEntity;
import com.example.linkedin_scrapper.services.EducationService;
import com.example.linkedin_scrapper.services.ExperienceService;
import com.example.linkedin_scrapper.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
@Slf4j
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
            Integer year = 2000;

            log.info("Starting...");

            List<UserEntity> userEntities = userService.requestUser(year, 0);

//            while (year <= 2024) {
//                while (!userEntities.isEmpty()) {
            log.info("Found users: {}", userEntities);
            for (UserEntity userEntity : userEntities) {
                log.info("Retrieving info of user: {}", userEntity);
                experienceService.requestExperience(userEntity);
                educationService.requestEducation(userEntity);
            }
            log.info("Requesting new page");
            Thread.sleep(2000);
//            userEntities = userService.requestUser(year, userEntities.size());
//                }
//                userEntities = userService.requestUser(++year, 0);
//            }
        };
    }
}