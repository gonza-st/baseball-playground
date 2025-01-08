package org.gonza.javaplayground.core;

public class BaseballGame {
    private final BaseballGameRule rule;
    private Numbers computerNumbers;

    public BaseballGame(BaseballGameRule rule) {
        this.rule = rule;
        this.computerNumbers = rule.generateNumbers();
    }

    public GameResult guess(Numbers playerNumbers) {
        return rule.guess(computerNumbers, playerNumbers);
    }

    public void restart() {
        this.computerNumbers = rule.generateNumbers();
    }
}
