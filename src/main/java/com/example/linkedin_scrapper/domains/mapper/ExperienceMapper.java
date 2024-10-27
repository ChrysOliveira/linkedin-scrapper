package com.example.linkedin_scrapper.domains.mapper;

import com.example.linkedin_scrapper.domains.DTOs.ExperienceDTO;
import com.example.linkedin_scrapper.domains.entities.ExperienceEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ExperienceMapper {
    public ExperienceEntity ExperienceDataToExperienceEntity(ExperienceDTO.ExperienceData extracted, Integer index){
        String infoCompany = extracted
                .getComponents()
                .getElements()
                .get(index)
                .getComponentsInner()
                .getEntityComponent()
                .getSubtitle()
                .getText();

        String company = infoCompany.split(" · ")[0];
        String workload = infoCompany.split(" · ")[1];

        String period = extracted.getComponents()
                .getElements()
                .get(index)
                .getComponentsInner()
                .getEntityComponent()
                .getCaption()
                .getText();

        String location = extracted.getComponents()
                .getElements()
                .get(index)
                .getComponentsInner()
                .getEntityComponent()
                .getMetadata()
                .getText();

        StringBuilder description = new StringBuilder();

        int lengthComponentsDescription = extracted
                .getComponents()
                .getElements()
                .get(index)
                .getComponentsInner()
                .getEntityComponent()
                .getSubComponents()
                .getComponentsLists()
                .size();

        for(int i = 0; i < lengthComponentsDescription; i++){
            description.append(extracted.getComponents()
                    .getElements()
                    .get(index)
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

        return ExperienceEntity.builder()
                .company(company)
                .workload(workload)
                .period(period)
                .location(location)
                .description(description.toString())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
