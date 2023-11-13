package com.example.javaspring.Service;

import com.example.javaspring.config.BotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig config;
    @Autowired

    public TelegramBot(BotConfig config) {
        super(config.getToken());
        this.config = config;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            switch (messageText) {
                case "/start":
                        startCommandReceived(chatId,
                                update.getMessage().getChat().getFirstName());
                        break;
                case "/hui":
                        startCommandGtfo(chatId,
                                update.getMessage().getChat().getFirstName());
                        break;
                default:
                    sendMessage(chatId, "Sorry, command was not recognized");
                }
            }

        }

    private void startCommandReceived(long chatId, String firstName) {
        String answer = "Hello, " + firstName + ", nice to meet you";


        sendMessage(chatId,answer);
    }

    private void startCommandGtfo(long chatId, String firstName) {
        final String ytLink =
                "https://www.youtube.com/watch?v=1Qo35ldlvWo&pp=ygUu0LLRiyDQutGC0L4g0YLQsNC60LjQtSDRjyDQstCw0YEg0L3QtSDQt9Cy0LDQuw%3D%3D";
        String answer = "Сам ты хуй, " + firstName;
        sendMessage(chatId,answer);
        sendMessage(chatId,ytLink);
    }

    private void sendMessage(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }
}
