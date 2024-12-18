package org.gonza.javaplayground;

import java.util.Scanner;

public class InputView {

    public static String inputNumber() {
        OutputView.enterNumber();
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static int inputRetryNumber() {
        OutputView.printSelectRetry();
        Scanner scanner = new Scanner(System.in);

        int continueSelectAnswer = scanner.nextInt();

        try {
            validate(continueSelectAnswer);
        } catch (IllegalArgumentException e) {
            OutputView.announceRetryException();
            return inputRetryNumber();
        }

        return continueSelectAnswer;
    }

    private static void validate(int isContinueNumber) {
        if (isContinueNumber != 1 && isContinueNumber != 2) {
            throw new IllegalArgumentException();
        }
    }
}
