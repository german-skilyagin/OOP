package org.example.console;

import org.example.InputReader;
import org.example.logic.BotRequest;

import java.util.Scanner;

public class Reader implements InputReader {
    private static final Scanner scanner = new Scanner(System.in);

    public BotRequest getUserInput() {
        return (new BotRequest(scanner.nextLine(), null));
    }
}
