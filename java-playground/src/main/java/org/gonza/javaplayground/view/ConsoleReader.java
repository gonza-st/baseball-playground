package org.gonza.javaplayground.view;

import org.gonza.javaplayground.util.Validator;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    private final Scanner scanner;

    public ConsoleReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readWithValidation() {
        String input = scanner.nextLine();
        Validator.validateNumeric(input);
        Validator.validateLength(input);
        Validator.validateDuplication(input);

        return input;
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }
}
