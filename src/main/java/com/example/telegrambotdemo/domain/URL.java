package com.example.telegrambotdemo.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "fullLink",
        "date",
        "shortLink",
        "title"
})

public class URL {

    @JsonProperty("status")
    private Integer status;
    @JsonProperty("fullLink")
    private String fullLink;
    @JsonProperty("date")
    private String date;
    @JsonProperty("shortLink")
    private String shortLink;
    @JsonProperty("title")
    private String title;

    public String getFullLink() {
        return fullLink;
    }

    public String getShortLink() {
        return shortLink;
    }

    @Override
    public String toString() {
        return "\n\uD83D\uDD17Полная ссылка : ```" +  fullLink + "```" +
                "\n\n\uD83D\uDD58Дата : *" + date + "*" +
                "\n\n\uD83D\uDD17Короткая ссылка: " + shortLink +
                "\n\n\uD83D\uDCDCНазвание: *" + title + "*";
    }
}