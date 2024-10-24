package com.example.linkedin_scrapper.services;

import com.example.linkedin_scrapper.clients.ListPeopleClient;
import com.example.linkedin_scrapper.domains.DTOs.ListPeopleDTO;
import com.example.linkedin_scrapper.domains.entities.UserEntity;
import com.example.linkedin_scrapper.domains.mapper.UserMapper;
import com.example.linkedin_scrapper.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final ListPeopleClient listPeopleClient;
    private final ObjectMapper objectMapper;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(ListPeopleClient listPeopleClient, ObjectMapper objectMapper, UserMapper userMapper, UserRepository userRepository) {
        this.listPeopleClient = listPeopleClient;
        this.objectMapper = objectMapper;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    // TODO: remover teste
    public void blabla() throws JsonProcessingException {
        RestClient restClient = listPeopleClient.getRestClient();
        var resultado = listPeopleClient.execRestClient(restClient, 0);
        ListPeopleDTO listPeopleDTO = objectMapper.readValue(resultado, ListPeopleDTO.class);
        List<ListPeopleDTO.UserData> list = listPeopleDTO.getIncluded().stream().filter(user -> user.getNavigationUrl() != null).toList();

        for (ListPeopleDTO.UserData userData : list) {
            UserEntity userEntity = userMapper.integration(userData);
            userRepository.save(userEntity);
        }

        System.out.println(list);
    }

}
