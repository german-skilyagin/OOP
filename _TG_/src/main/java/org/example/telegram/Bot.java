package org.example.telegram;

import org.example.AnswerWriter;
import org.example.MessageHandler;
import org.example.logic.BotRequest;
import org.example.logic.BotResponse;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot implements AnswerWriter {
    private final BotConverter converter = new BotConverter();
    private final MessageHandler messageHandler;

    public Bot(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    @Override
    public String getBotToken() {
        return BotConfig.BOT_TOKEN;
    }
    @Override
    public String getBotUsername() {
        return BotConfig.BOT_NAME;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            BotRequest request = converter.convert(update);
            messageHandler.handle(request, this);
        }
    }

    @Override
    public void writeAnswer(BotResponse response) {
        //Создаем объект класса SendMessage - наш будущий ответ пользователю
        SendMessage outMessage = new SendMessage();

        // Добавляем в наше сообщение id чата и ответ
        outMessage.setChatId(response.getChatId());
        outMessage.setText(response.getResponseText());

        // Отправка в чат
        try {
            execute(outMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
