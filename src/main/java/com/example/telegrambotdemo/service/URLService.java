package com.example.telegrambotdemo.service;

import com.example.telegrambotdemo.domain.URL;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Service;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url"
})

@Service
public class URLService {

    @JsonProperty("url")
    private URL url;

    public String getUrlInfo(){
        return url.toString();
    }

    public String getUrlFullString(){
        return url.getFullLink();
    }

    public String getShortLink(){
        return url.getShortLink();
    }


    @Override
    public String toString() {
        return "Long url = " + url.getFullLink() + "\nShort url = " + url.getShortLink();
    }
}