package com.example.linkedin_scrapper.domains.mapper;

import com.example.linkedin_scrapper.domains.DTOs.ExperienceDTO;
import com.example.linkedin_scrapper.domains.entities.ExperienceEntity;
import com.example.linkedin_scrapper.domains.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ExperienceMapper {
    public ExperienceEntity ExperienceDataToExperienceEntity(ExperienceDTO.ExperienceData.Components.Elements extracted, UserEntity userEntity){
        String infoCompany = extracted
                .getComponentsInner()
                .getEntityComponent()
                .getSubtitle()
                .getText();

        String company = infoCompany.split(" · ")[0];
        String workload = infoCompany.split(" · ")[1];

        String period = extracted
                .getComponentsInner()
                .getEntityComponent()
                .getCaption()
                .getText();

        String location = extracted
                .getComponentsInner()
                .getEntityComponent()
                .getMetadata()
                .getText();

        StringBuilder description = new StringBuilder();

        if(extracted.getComponentsInner().getEntityComponent().getSubComponents() != null){
            int lengthComponentsDescription = extracted
                    .getComponentsInner()
                    .getEntityComponent()
                    .getSubComponents()
                    .getComponentsLists()
                    .size();

            for(int i = 0; i < lengthComponentsDescription; i++){
                description.append(extracted
                        .getComponentsInner()
                        .getEntityComponent()
                        .getSubComponents()
                        .getComponentsLists()
                        .get(i)
                        .getComponents()
                        .getFixedListComp()
                        .getComponents()
                        .get(0)
                        .getComponents()
                        .getTextComponent()
                        .getText()
                        .getText()
                );
            }
        }

        return ExperienceEntity.builder()
                .company(company)
                .workload(workload)
                .period(period)
                .location(location)
                .description(description.toString())
                .user(userEntity)
                .createdAt(LocalDateTime.now())
                .build();
    }
}