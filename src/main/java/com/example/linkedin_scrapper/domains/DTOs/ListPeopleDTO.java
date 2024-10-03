package com.example.linkedin_scrapper.domains.DTOs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ListPeopleDTO {
    private List<UserData> included;

    @Getter
    @Setter
    @ToString
    private static class UserData {
        private String navigationUrl;
    }
}