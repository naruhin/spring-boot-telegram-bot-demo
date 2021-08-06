package com.example.telegrambotdemo.service;

import com.example.telegrambotdemo.web.ShortURLClient;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    public SendMessage onUpdateReceived(Update update) throws IOException, InterruptedException {
        SendMessage sendMessage = new SendMessage();


        if(update != null){
            Message message = update.getMessage();
            ShortURLClient client = new ShortURLClient();
            sendMessage.setChatId(message.getChatId());
            //sendMessage.setParseMode("Markdown").disableWebPagePreview();


            if(message.hasText()){
                String messageText = message.getText();
                switch(messageText){
                    case "/start":
                    case "/start@shortmyurlbot":
                        return sendMessage.setText("Привет\uD83D\uDE0E! Я @shortmyurlbot, бот который делает твои ссылки короткими и удобными! Просто пришли мне ссылку\uD83D\uDD17.");
                    case "/settings":
                    case "/settings@shortmyurlbot":
                        return sendMessage.setText("Скоро!");
                    case "/help":
                    case "/help@shortmyurlbot":
                        return sendMessage.setText("Если возникли какие-то вопросы или пожелания пиши: @durango_95 \uD83E\uDDD0");
                    default:
                        if(message.hasEntities()){
                            List<MessageEntity> entities = message.getEntities();
                            URLService urlService;
                            sendMessage.setParseMode("Markdown").disableWebPagePreview();

                            for (MessageEntity ent: entities) {
                                String url = ent.getText();
                                urlService = client.getShortURL(url);
                                return sendMessage.setText(urlService.getUrlInfo());
                            }
                        }
                        else {
                            return sendMessage.setText("Я жду ссылку\uD83E\uDD7A");
                        }

                }
            }
        }
        return sendMessage.setText("Не понимаю! \uD83D\uDE33");
    }

}
