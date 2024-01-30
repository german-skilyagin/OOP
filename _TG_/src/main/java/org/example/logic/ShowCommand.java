package org.example.logic;

import org.example.AnswerWriter;

public class ShowCommand implements Command {
    public static final String NAME = "/show";

    @Override
    public boolean needExecute(UserData userData, BotRequest request) {
        return NAME.equals(request.getRequestText());
    }

    @Override
    public void execute(UserData userData, BotRequest request, AnswerWriter writer) {

    }
}
