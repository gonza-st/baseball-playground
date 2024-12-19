package org.gonza.javaplayground.core;

import java.util.List;

public class BaseballGame {
    private final BaseballGameRule rule;
    private List<Integer> computerNumbers;

    public BaseballGame(BaseballGameRule rule) {
        this.rule = rule;
        this.computerNumbers = rule.generateNumbers();
    }

    public GameResult guess(List<Integer> playerNumbers) {
        return rule.guess(computerNumbers, playerNumbers);
    }

    public void restart() {
        this.computerNumbers = rule.generateNumbers();
    }
}
