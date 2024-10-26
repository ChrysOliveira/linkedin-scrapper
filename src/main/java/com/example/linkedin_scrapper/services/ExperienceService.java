package com.example.linkedin_scrapper.services;

import com.example.linkedin_scrapper.clients.ExperienceClient;
import com.example.linkedin_scrapper.domains.DTOs.ExperienceDTO;
import com.example.linkedin_scrapper.domains.DTOs.ListPeopleDTO;
import com.example.linkedin_scrapper.domains.mapper.ExperienceMapper;
import com.example.linkedin_scrapper.repositories.ExperienceRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ExperienceService {
    private final ExperienceClient experienceClient;
    private final ObjectMapper objectMapper;
    private final ExperienceRepository experienceRepository;
    private final ExperienceMapper experienceMapper;

    public ExperienceService(ExperienceClient experienceClient, ObjectMapper objectMapper, ExperienceRepository experienceRepository, ExperienceMapper experienceMapper) {
        this.experienceClient = experienceClient;
        this.objectMapper = objectMapper;
        this.experienceRepository = experienceRepository;
        this.experienceMapper = experienceMapper;
    }

    public void requestExperience() throws JsonProcessingException {
        RestClient restClient = experienceClient.getRestClient();
        var result = experienceClient.execRestClient(restClient, "");
        ExperienceDTO listPeopleDTO = objectMapper.readValue(result, ExperienceDTO.class);

        System.out.println(listPeopleDTO);
    }

}
