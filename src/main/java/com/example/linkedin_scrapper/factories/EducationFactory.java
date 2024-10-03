package com.example.linkedin_scrapper.factories;

import com.example.linkedin_scrapper.domains.entities.EducationEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EducationFactory {

    private final ObjectMapper objectMapper;

    public EducationFactory(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public EducationEntity createEducationEntity(String json) throws JsonProcessingException {
        var educationEntity = objectMapper.readValue(json, EducationEntity.class);
        educationEntity.setCreatedAt(LocalDateTime.now());
        return educationEntity;
    }
}