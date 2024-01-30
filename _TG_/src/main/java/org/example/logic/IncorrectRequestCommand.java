package org.example.logic;

import org.example.AnswerWriter;

public class IncorrectRequestCommand implements Command {
    @Override
    public boolean needExecute(UserData userData, BotRequest request) {
        return true;
    }

    @Override
    public void execute(UserData userData, BotRequest request, AnswerWriter writer) {
        writer.writeAnswer(new BotResponse("Не понял запрос", request.getChatId()));
    }
}
