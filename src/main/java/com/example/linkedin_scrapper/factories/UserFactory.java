package com.example.linkedin_scrapper.factories;

import com.example.linkedin_scrapper.domains.entities.UserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserFactory {

    private final ObjectMapper objectMapper;

    public UserFactory(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public UserEntity createUserEntity() throws JsonProcessingException {
//        var userEntity = objectMapper.readValue(json, UserEntity.class);

        return null;
        // userEntity.setCreatedAt();
//        return userEntity;
    }
}