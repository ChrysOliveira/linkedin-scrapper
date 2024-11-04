package com.example.linkedin_scrapper.services;

import com.example.linkedin_scrapper.clients.EducationClient;
import com.example.linkedin_scrapper.clients.ExperienceClient;
import com.example.linkedin_scrapper.domains.DTOs.EducationDTO;
import com.example.linkedin_scrapper.domains.DTOs.ExperienceDTO;
import com.example.linkedin_scrapper.domains.entities.EducationEntity;
import com.example.linkedin_scrapper.domains.entities.ExperienceEntity;
import com.example.linkedin_scrapper.domains.mapper.EducationMapper;
import com.example.linkedin_scrapper.domains.mapper.ExperienceMapper;
import com.example.linkedin_scrapper.repositories.EducationRepository;
import com.example.linkedin_scrapper.repositories.ExperienceRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class EducationService {
    private final EducationClient educationClient;
    private final ObjectMapper objectMapper;
    private final EducationRepository educationRepository;
    private final EducationMapper educationMapper;

    public EducationService(EducationClient educationClient, ObjectMapper objectMapper, EducationRepository educationRepository, EducationMapper educationMapper) {
        this.educationClient = educationClient;
        this.objectMapper = objectMapper;
        this.educationRepository = educationRepository;
        this.educationMapper = educationMapper;
    }

    public void requestEducation() throws JsonProcessingException {
        RestClient restClient = educationClient.getRestClient();
        var result = educationClient.execRestClient(restClient, "");
        EducationDTO educationDTO = objectMapper.readValue(result, EducationDTO.class);
        List<EducationDTO.EducationData> educationDataList = educationDTO.getIncluded().stream().filter(decorationType -> decorationType.getDecorationType() != null
                && decorationType.getDecorationType().equals("LINE_SEPARATED")).toList();

        for (EducationDTO.EducationData educationData : educationDataList){
            for(EducationDTO.EducationData.Components.Elements elements: educationData.getComponents().getElements()){
                EducationEntity educationEntity = educationMapper.EducationDataToEducationEntity(elements, null);
                educationRepository.save(educationEntity);
            }
        }

        System.out.println(educationDataList);
    }
}
