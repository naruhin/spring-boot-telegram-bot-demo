package com.example.telegrambotdemo.web;

import com.example.telegrambotdemo.service.URLService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Component
@PropertySource("classpath:application.properties")
public class ShortURLClient {
    private static final String SHORT_URL_API = "https://cutt.ly/api/api.php?key=&short=";


    private static String apiToken;

    public String getApiToken() {
        return apiToken;
    }

    @Value("${api.token}")
    public void setNameStatic(String apiToken){
        ShortURLClient.apiToken = apiToken;
    }

    public ShortURLClient() {
    }

    public String setRequest(String fullLink){
        StringBuilder sb = new StringBuilder();
        sb.append(SHORT_URL_API);
        sb.insert(sb.indexOf("key=") + 4, getApiToken());
        //sb.replace(sb.indexOf("["),sb.lastIndexOf("]"),getApiToken());
        sb.append(fullLink);
        return sb.toString();
    }

    public URLService getShortURL(String fullLink) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("Accept", "application/json")
                .uri(URI.create(setRequest(fullLink)))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //parse JSOn into objects

        ObjectMapper mapper = new ObjectMapper();

        URLService url = mapper.readValue(response.body(), new TypeReference<>() {});

       return  url;
    }


}
