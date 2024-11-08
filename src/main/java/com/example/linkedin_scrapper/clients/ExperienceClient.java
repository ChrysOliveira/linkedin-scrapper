package com.example.linkedin_scrapper.clients;

import com.example.linkedin_scrapper.utils.Utils;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ExperienceClient implements IClient {
    @Override
    public RestClient getRestClient(){
        return RestClient.builder().build();
    }

    public String execRestClient(RestClient restClient, String linkedinId){
//        return Utils.retornaJson("jsons/experience.json");
        return Utils.retornaJson("jsons/experience_muitaslistas.json");
    }
}
