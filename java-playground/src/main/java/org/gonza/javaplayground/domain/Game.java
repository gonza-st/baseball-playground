package org.gonza.javaplayground.domain;

import org.gonza.javaplayground.exception.DuplicateValueException;
import org.gonza.javaplayground.exception.InvalidNumberLengthException;
import org.gonza.javaplayground.exception.InvalidLengthException;
import org.gonza.javaplayground.exception.NotNumberIncludedException;
import org.gonza.javaplayground.ui.View;

import java.util.List;

public class Game {

    private final NumberGenerator numberGenerator;
    private final InputParser inputParser;
    private final View view;
    private final Rule rule;
    private final Referee referee;

    public Game(
        NumberGenerator numberGenerator,
        InputParser inputParser,
        View view,
        Rule rule,
        Referee referee
    ) {
        this.numberGenerator = numberGenerator;
        this.inputParser = inputParser;
        this.view = view;
        this.rule = rule;
        this.referee = referee;
    }

    public void start() {
        Answer answer = getAnswer();

        while (true) {
            int number = getNumber();
            List<Result> resultList = referee.judge(answer, number);

            if (referee.isAllStrike(resultList)) {
                gameEnd();
                break;
            }
            view.printResult(resultList);
        }
    }

    private void gameEnd() {
        view.gameEnd();
        if (isRestart(view.restartOrExit())) {
            start();
        }
    }

    private Answer getAnswer() {
        int answerNumber = numberGenerator.generate();
        List<Integer> number = inputParser.parseToList(answerNumber);
        return new Answer(number);
    }

    private int getNumber() {
        while (true) {
            String input = view.requestInput();
            try {
                rule.validateNumber(input);
                List<Integer> number = inputParser.parseToList(input);

                rule.validateDuplicateValue(number);
                rule.validateMaxSize(number);
                return Integer.parseInt(input);
            } catch (NotNumberIncludedException | InvalidNumberLengthException | DuplicateValueException e) {
                view.printErrorMessage(e.getMessage());
            }
        }
    }

    private boolean isRestart(String input) {
        while (true) {
            try {
                rule.validateRestartOrExitFlag(input);
                return rule.isRestart(input);
            } catch (InvalidLengthException e) {
                view.printErrorMessage(e.getMessage());
            }
        }
    }
}
