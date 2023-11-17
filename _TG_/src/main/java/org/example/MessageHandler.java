package org.example;

import org.example.logic.BotRequest;

public interface MessageHandler {
    void handle(BotRequest request, AnswerWriter writer);
}
