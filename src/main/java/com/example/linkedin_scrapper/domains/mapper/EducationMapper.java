package com.example.linkedin_scrapper.domains.mapper;

import com.example.linkedin_scrapper.domains.DTOs.EducationDTO;
import com.example.linkedin_scrapper.domains.DTOs.ExperienceDTO;
import com.example.linkedin_scrapper.domains.entities.EducationEntity;
import com.example.linkedin_scrapper.domains.entities.ExperienceEntity;
import com.example.linkedin_scrapper.domains.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EducationMapper {
    public EducationEntity EducationDataToEducationEntity(EducationDTO.EducationData.Components.Elements extracted, UserEntity userEntity) {
        String period = extracted
                .getComponentsInner()
                .getEntityComponent()
                .getCaption() != null ? extracted
                .getComponentsInner()
                .getEntityComponent()
                .getCaption().getText() : "";

        String college = extracted
                .getComponentsInner()
                .getEntityComponent()
                .getTitle()
                .getText()
                .getText();

        String course = extracted
                .getComponentsInner()
                .getEntityComponent()
                .getSubtitle() != null ? extracted
                .getComponentsInner()
                .getEntityComponent()
                .getSubtitle().getText() : "";

        StringBuilder description = new StringBuilder();

        if (extracted.getComponentsInner().getEntityComponent().getSubComponents() != null) {
            int lengthComponentsDescription = extracted
                    .getComponentsInner()
                    .getEntityComponent()
                    .getSubComponents()
                    .getComponentsLists()
                    .size();


            for (int i = 0; i < lengthComponentsDescription; i++) {
                int validationSize = 0;
                if (extracted.getComponentsInner().getEntityComponent().getSubComponents().getComponentsLists().get(i).getComponents().getFixedListComp() != null) {
                    validationSize = extracted
                            .getComponentsInner()
                            .getEntityComponent()
                            .getSubComponents()
                            .getComponentsLists()
                            .get(i)
                            .getComponents()
                            .getFixedListComp()
                            .getComponents()
                            .size();

                    if (validationSize > 0) {
                        if (extracted.getComponentsInner().getEntityComponent().getSubComponents().getComponentsLists().get(i).getComponents().getFixedListComp().getComponents().get(0).getComponents().getTextComponent() != null) {
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
                                    .getText());
                        }
                    }
                } else if (extracted.getComponentsInner().getEntityComponent().getSubComponents().getComponentsLists().get(i).getComponents().getInsightComponent() != null) {
                    validationSize = extracted
                            .getComponentsInner()
                            .getEntityComponent()
                            .getSubComponents()
                            .getComponentsLists()
                            .get(i)
                            .getComponents()
                            .getInsightComponent()
                            .getText() != null ? 1 : 0;

                    if (validationSize > 0) {
                        description.append(extracted
                                .getComponentsInner()
                                .getEntityComponent()
                                .getSubComponents()
                                .getComponentsLists()
                                .get(i)
                                .getComponents()
                                .getInsightComponent()
                                .getText()
                                .getText()
                                .getText());
                    }
                }
            }
        }

        return EducationEntity.builder()
                .period(period)
                .college(college)
                .course(course)
                .description(description.toString())
                .user(userEntity)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
