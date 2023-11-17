package org.example.telegram;

import org.example.logic.BotRequest;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class BotConverter {
    public BotRequest convert(Update update) {
        Message message = update.getMessage();
        String messageText = message.getText();
        String chatId = message.getChatId().toString();

        return new BotRequest(messageText, chatId);
    }
}
