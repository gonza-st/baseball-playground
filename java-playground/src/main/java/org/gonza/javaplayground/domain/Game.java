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
    private final RuleValidator ruleValidator;
    private final Referee referee;

    public Game(
        NumberGenerator numberGenerator,
        InputParser inputParser,
        View view,
        Rule rule,
        RuleValidator ruleValidator,
        Referee referee
    ) {
        this.numberGenerator = numberGenerator;
        this.inputParser = inputParser;
        this.view = view;
        this.rule = rule;
        this.ruleValidator = ruleValidator;
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
                ruleValidator.validateNumericInput(input);
                List<Integer> number = inputParser.parseToList(input);

                ruleValidator.validateDuplicateValue(number);
                ruleValidator.validateRequiredSize(number);
                return Integer.parseInt(input);
            } catch (NotNumberIncludedException | InvalidNumberLengthException | DuplicateValueException e) {
                view.printErrorMessage(e.getMessage());
            }
        }
    }

    private boolean isRestart(String input) {
        while (true) {
            try {
                ruleValidator.validateRestartOrExitFlag(input);
                return rule.isRestart(input);
            } catch (InvalidLengthException e) {
                view.printErrorMessage(e.getMessage());
            }
        }
    }
}
