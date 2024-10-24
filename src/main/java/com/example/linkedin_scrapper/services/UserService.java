package com.example.linkedin_scrapper.services;

import com.example.linkedin_scrapper.clients.ListPeopleClient;
import com.example.linkedin_scrapper.domains.DTOs.ListPeopleDTO;
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

    public UserService(ListPeopleClient listPeopleClient, ObjectMapper objectMapper) {
        this.listPeopleClient = listPeopleClient;
        this.objectMapper = objectMapper;
    }

    // TODO: remover teste
    public void blabla() throws JsonProcessingException {
        RestClient restClient = listPeopleClient.getRestClient();
        var resultado = listPeopleClient.execRestClient(restClient, 0);
        ListPeopleDTO listPeopleDTO = objectMapper.readValue(resultado, ListPeopleDTO.class);
        List<ListPeopleDTO.UserData> list = listPeopleDTO.getIncluded().stream().filter(user -> user.getNavigationUrl() != null).toList();
        System.out.println(list);
    }

}
