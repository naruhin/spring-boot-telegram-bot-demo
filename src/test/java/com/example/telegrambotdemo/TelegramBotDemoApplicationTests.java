package com.example.telegrambotdemo;

import com.example.telegrambotdemo.config.Mapper;
import com.example.telegrambotdemo.service.MessageService;
import com.example.telegrambotdemo.service.TelegramBot;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = {TelegramBot.class, Mapper.class, MessageService.class})
public
class TelegramBotDemoApplicationTests {

    @Test
    void contextLoads() {
    }

}
