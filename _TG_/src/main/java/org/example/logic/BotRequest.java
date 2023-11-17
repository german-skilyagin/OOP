package org.example.logic;

public class BotRequest {
    private final String requestText;
    private final String chatId;

    public BotRequest(String data, String chatId) {
        this.requestText = data;
        this.chatId = chatId;
    }

    public String getRequestText() {
        return requestText;
    }

    public boolean isStopMessage() {
        return requestText.equals("/break");
    }
    public String getChatId() {
        return chatId;
    }
}
