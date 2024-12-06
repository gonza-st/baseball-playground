package org.gonza.javaplayground.view;

import org.gonza.javaplayground.util.Validator;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    private final Scanner scanner;

    public ConsoleReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String read() {
        String input = scanner.nextLine();
        Validator.validateNumeric(input);
        Validator.validateDuplication(input);
        Validator.validateLength(input);

        return input;
    }

    @Override
    public String readWithoutValidation() {
        return scanner.nextLine();
    }
}
