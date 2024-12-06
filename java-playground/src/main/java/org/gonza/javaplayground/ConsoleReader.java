package org.gonza.javaplayground;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    private final Scanner scanner;
    private final Validator validator;

    public ConsoleReader(Scanner scanner, Validator validator) {
        this.scanner = scanner;
        this.validator = validator;
    }

    @Override
    public String read() {
        String input = scanner.nextLine();
        validator.validate(input);
        return input;
    }

    @Override
    public String readWithoutValidation() {
        return scanner.nextLine();
    }
}
