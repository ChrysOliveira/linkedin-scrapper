package com.example.linkedin_scrapper.factories;

import com.example.linkedin_scrapper.entities.ExperienceEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ExperienceFactory {

    private final ObjectMapper objectMapper;

    public ExperienceFactory(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ExperienceEntity createExperienceEntity(String json) throws JsonProcessingException {
        var experienceEntity = objectMapper.readValue(json, ExperienceEntity.class);
        experienceEntity.setCreatedAt(LocalDateTime.now());
        return experienceEntity;
    }
}