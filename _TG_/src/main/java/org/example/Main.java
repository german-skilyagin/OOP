package org.example;


import org.example.logic.BotRequest;
import org.example.logic.Handler;
import org.example.telegram.Bot;
import org.example.console.Reader;
import org.example.console.Writer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
public class Main {
    public static void main (String[] args) {
        Handler handler = new Handler();

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Bot(handler));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        Reader reader = new Reader();
        Writer writer = new Writer();

        BotRequest message = reader.getUserInput();

        while (!message.isStopMessage()) {
            handler.handle(message, writer);
            message = reader.getUserInput();
        }
    }
}
