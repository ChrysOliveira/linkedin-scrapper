package com.example.linkedin_scrapper;

import com.example.linkedin_scrapper.clients.ListPeopleClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class LinkedinScrapperApplication {

    final ListPeopleClient listPeopleClient;

    public LinkedinScrapperApplication(ListPeopleClient listPeopleClient) {
        this.listPeopleClient = listPeopleClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(LinkedinScrapperApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
//            RestClient restClient = listPeopleClient.getRestClient();
//            System.out.println(listPeopleClient.execRestClient(restClient, 0));
        };
    }
}