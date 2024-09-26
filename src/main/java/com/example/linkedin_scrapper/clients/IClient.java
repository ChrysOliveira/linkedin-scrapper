package com.example.linkedin_scrapper.clients;

import org.springframework.web.client.RestClient;

public interface IClient {
    RestClient getRestClient();
}
