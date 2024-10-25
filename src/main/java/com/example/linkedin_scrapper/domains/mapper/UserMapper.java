package com.example.linkedin_scrapper.domains.mapper;

import com.example.linkedin_scrapper.domains.DTOs.ListPeopleDTO;
import com.example.linkedin_scrapper.domains.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {
    public UserEntity UserDataToUserEntity(ListPeopleDTO.UserData extracted){
        String fullPath = extracted.getNavigationUrl();

        String name = extracted.getTitle().getText();
        String linkedinProfile = fullPath.split("\\?")[0];
        String linkedinId = fullPath.substring(fullPath.length() - 44);

       return UserEntity.builder()
                .name(name)
                .linkProfile(linkedinProfile)
                .linkedinId(linkedinId)
                .createdAt(LocalDateTime.now()).build();
    }
}
