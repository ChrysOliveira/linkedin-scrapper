package com.example.linkedin_scrapper.domains.mapper;

import com.example.linkedin_scrapper.domains.DTOs.ExperienceDTO;
import com.example.linkedin_scrapper.domains.entities.ExperienceEntity;
import com.example.linkedin_scrapper.domains.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ExperienceMapper {
    public ExperienceEntity ExperienceDataToExperienceEntity(ExperienceDTO.ExperienceData.Components.Elements extracted, UserEntity userEntity) {
        String infoCompany = extracted
                .getComponentsInner()
                .getEntityComponent()
                .getSubtitle()
                .getText();

        String company = infoCompany.split(" · ")[0];
        String workload = "";
        String[] split = infoCompany.split(" · ");

        workload = split.length > 1 ? split[1] : split[0];

        String period = extracted
                .getComponentsInner()
                .getEntityComponent()
                .getCaption()
                .getText();

        ExperienceDTO.ExperienceData.Components.Elements.ComponentsInner.EntityComponent.Metadata metadata = extracted
                .getComponentsInner()
                .getEntityComponent()
                .getMetadata();

        String location;

        location = metadata != null ? metadata.getText() : "";

        StringBuilder description = new StringBuilder();

        if (extracted.getComponentsInner().getEntityComponent().getSubComponents() != null) {
            int lengthComponentsDescription = extracted
                    .getComponentsInner()
                    .getEntityComponent()
                    .getSubComponents()
                    .getComponentsLists()
                    .size();

            for (int i = 0; i < lengthComponentsDescription; i++) {
                ExperienceDTO.ExperienceData.Components.Elements.ComponentsInner.EntityComponent.SubComponents.ComponentsList.InnerComponent.FixedListComp fixedListComp = extracted
                        .getComponentsInner()
                        .getEntityComponent()
                        .getSubComponents()
                        .getComponentsLists()
                        .get(i)
                        .getComponents()
                        .getFixedListComp();
                List<ExperienceDTO.ExperienceData.Components.Elements.ComponentsInner.EntityComponent.SubComponents.ComponentsList.InnerComponent.FixedListComp.InnerComponentFixedList> components = null;

                if (fixedListComp != null) {
                    components = fixedListComp.getComponents();
                }
                if (components != null) {
                    description.append(components
                            .get(0)
                            .getComponents()
                            .getTextComponent()
                            .getText()
                            .getText());
                }
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
