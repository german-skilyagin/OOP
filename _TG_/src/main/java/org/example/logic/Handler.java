package org.example.logic;

import org.example.AnswerWriter;
import org.example.MessageHandler;

public class Handler implements MessageHandler {
    public void handle (BotRequest request, AnswerWriter writer) {
        BotResponse answer = new BotResponse(request.getRequestText(), request.getChatId());
        writer.writeAnswer(answer);
    }
}
