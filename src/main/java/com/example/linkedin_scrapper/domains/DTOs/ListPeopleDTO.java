package com.example.linkedin_scrapper.domains.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    public static class UserData {
        private String navigationUrl;
        private Nome title;
    }

    @Getter
    @Setter
    @ToString
    public static class Nome {
        private String text;
    }

}