package org.example.logic;

import org.example.AnswerWriter;

public class AddCommand implements Command {
    private static final String NAME = "/add";

    @Override
    public boolean needExecute(UserData userData, BotRequest request) {
        return NAME.equals(request.getRequestText());
    }

    @Override
    public void execute(UserData userData, BotRequest request, AnswerWriter writer) {

    }
}