package com.example.telegrambotdemo.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MessageService {
    public SendMessage onUpdateReceived(Update update){
        SendMessage sendMessage = new SendMessage();

        if(update != null){
            Message message = update.getMessage();
            sendMessage.setChatId(message.getChatId());
            if(message.hasText()){
                String messageText = message.getText();
                switch(messageText){
                    case "/start":
                        return sendMessage.setText("Hello");
                    case "/settings":
                        return sendMessage.setText("Settings!");
                    case "/help":
                        return sendMessage.setText("Help!");
                }
            }
        }
        return sendMessage.setText("Do no");
    }

}
