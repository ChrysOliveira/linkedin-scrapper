package com.example.linkedin_scrapper.domains.mapper;

import com.example.linkedin_scrapper.domains.DTOs.ExperienceDTO;
import com.example.linkedin_scrapper.domains.entities.ExperienceEntity;
import com.example.linkedin_scrapper.domains.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExperienceMapper {
    public ExperienceEntity ExperienceDataToExperienceEntitySingleTitle(ExperienceDTO.ExperienceData.Components.Elements extracted, UserEntity userEntity) {
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

        // TODO: identificar quando estamos falando de competencias ou quando estamos falando de descricao de fato
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

    public List<ExperienceEntity> ExperienceDataToExperienceEntityMultiTitle(ExperienceDTO experienceDTO, ExperienceDTO.ExperienceData.Components.Elements extracted, UserEntity userEntity) {

        String company = extracted
                .getComponentsInner()
                .getEntityComponent()
                .getTitle()
                .getText()
                .getText();

        // TODO: adicionar uma coluna para pegar o tempo total na empresa (somatorio de todos os cargos NAO ESQUECER: pode ter dois cargos ao mesmo tempo)
//        String period = extracted
//                .getComponentsInner()
//                .getEntityComponent()
//                .getCaption()
//                .getText();

        String location =  extracted.getComponentsInner().getEntityComponent().getCaption() != null ? extracted.getComponentsInner().getEntityComponent().getCaption().getText() : "";

        ExperienceDTO.ExperienceData experienceDataDetails = experienceDTO.getIncluded().stream()
                .filter(decorationType -> decorationType.getDecorationType() != null
                        && !decorationType.getDecorationType().equals("LINE_SEPARATED"))
                .filter(included -> included.getComponents().getElements().stream().anyMatch(
                        element -> element.getComponentsInner().getEntityComponent().getTextActionTarget().equals(extracted.getComponentsInner().getEntityComponent().getTextActionTarget())))
                .findFirst()
                .orElse(null);

        List<ExperienceDTO.ExperienceData.Components.Elements> elements = experienceDataDetails.getComponents().getElements();

        List<ExperienceEntity> experienceEntities = new ArrayList<>();

        elements.forEach(element -> {
            experienceEntities.add(ExperienceEntity.builder()
                    .company(company)
                    .createdAt(LocalDateTime.now())
                    .description(element.getComponentsInner().getEntityComponent().getSubComponents().getComponentsLists().get(0).getComponents().getFixedListComp().getComponents().get(0).getComponents().getTextComponent().getText().getText())
                    .period(element.getComponentsInner().getEntityComponent().getCaption().getText())
                    .location(location)
                    .period(element.getComponentsInner().getEntityComponent().getCaption().getText())
                    .workload( element.getComponentsInner().getEntityComponent().getSubtitle() != null ? element.getComponentsInner().getEntityComponent().getSubtitle().getText() : "")
                    .build());
        });

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

        return experienceEntities;
    }
}
