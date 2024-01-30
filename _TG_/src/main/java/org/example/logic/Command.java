package org.example.logic;

import org.example.AnswerWriter;

public interface Command {
    boolean needExecute(UserData userData, BotRequest request);
    void execute(UserData userData, BotRequest request, AnswerWriter writer);
}
