package org.example.logic;

import org.example.AnswerWriter;
import org.example.MessageHandler;

import java.util.List;

public class Handler implements MessageHandler {
    private final UserDataService userDataService;
    private final List<Command> commands;

    public Handler(UserDataService userDataService, List<Command> commands) {
        this.userDataService = userDataService;
        this.commands = commands;
    }

    public void handle (BotRequest request, AnswerWriter writer) {
        UserData userData = userDataService.getOrCreateUserData(request.getChatId());

        for (Command command : commands) {
            if (command.needExecute(userData, request)) {
                command.execute(userData, request, writer);
                break;
            }
        }
//        BotResponse answer = new BotResponse(request.getRequestText(), request.getChatId());
//        writer.writeAnswer(answer);
    }
}
