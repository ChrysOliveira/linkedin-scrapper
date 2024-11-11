package com.example.linkedin_scrapper.services;

import com.example.linkedin_scrapper.clients.ExperienceClient;
import com.example.linkedin_scrapper.domains.DTOs.ExperienceDTO;
import com.example.linkedin_scrapper.domains.DTOs.ListPeopleDTO;
import com.example.linkedin_scrapper.domains.entities.ExperienceEntity;
import com.example.linkedin_scrapper.domains.entities.UserEntity;
import com.example.linkedin_scrapper.domains.mapper.ExperienceMapper;
import com.example.linkedin_scrapper.repositories.ExperienceRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

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

    public void requestExperience(UserEntity user) throws JsonProcessingException {
        RestClient restClient = experienceClient.getRestClient(user);

        var result = experienceClient.execRestClient(restClient, user.getLinkedinId());

        ExperienceDTO experienceDTO = objectMapper.readValue(result, ExperienceDTO.class);

        ExperienceDTO.ExperienceData experienceData = experienceDTO.getIncluded().stream()
                .filter(decorationType -> decorationType.getDecorationType() != null
                        && decorationType.getDecorationType().equals("LINE_SEPARATED"))
                .findFirst()
                .orElse(null);

        for (ExperienceDTO.ExperienceData.Components.Elements element : experienceData.getComponents().getElements()) {

            if (element.getComponentsInner().getEntityComponent() == null) {
                return;
            }

            if (element.getComponentsInner().getEntityComponent().getMetadata() != null) {
                ExperienceEntity experienceEntity = experienceMapper.ExperienceDataToExperienceEntitySingleTitle(element, user);
                experienceRepository.save(experienceEntity);
            } else {
                List<ExperienceEntity> experienceEntities = experienceMapper.ExperienceDataToExperienceEntityMultiTitle(experienceDTO, element, user);
                if (experienceEntities == null) {
                    continue;
                }
                experienceRepository.saveAll(experienceEntities);
            }
        }
    }
}
