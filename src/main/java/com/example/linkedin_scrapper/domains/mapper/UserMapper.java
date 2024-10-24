package com.example.linkedin_scrapper.domains.mapper;

import com.example.linkedin_scrapper.domains.DTOs.ListPeopleDTO;
import com.example.linkedin_scrapper.domains.entities.UserEntity;
import com.example.linkedin_scrapper.factories.UserFactory;

import java.time.LocalDateTime;
import java.util.List;

public class UserMapper {

    public UserEntity integration(ListPeopleDTO.UserData extracted){
       return UserEntity.builder()
               .name()
        .createdAt(LocalDateTime.now()).build();
    }
}
