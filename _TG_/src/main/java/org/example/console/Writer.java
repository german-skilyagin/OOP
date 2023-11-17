package org.example.console;

import org.example.AnswerWriter;
import org.example.logic.BotResponse;

public class Writer implements AnswerWriter {
    public void writeAnswer(BotResponse response) {
        System.out.println(response.getResponseText());
    }
}