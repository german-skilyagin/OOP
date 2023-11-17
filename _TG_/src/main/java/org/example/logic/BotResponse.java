package org.example.logic;

public class BotResponse {
    private final String responseText;
    private final String chatId;

    public BotResponse(String data, String chatId) {
        this.responseText = data;
        this.chatId = chatId;
    }

    public String getResponseText() {
        return responseText;
    }

    public String getChatId() {
        return chatId;
    }
}