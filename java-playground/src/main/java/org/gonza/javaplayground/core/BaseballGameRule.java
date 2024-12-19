package org.gonza.javaplayground.core;

import java.util.List;

public class BaseballGameRule {
    private final NumberGenerator numberGenerator;
    private final Judgement judgement;

    public BaseballGameRule(NumberGenerator numberGenerator, Judgement judgement) {
        this.numberGenerator = numberGenerator;
        this.judgement = judgement;
    }

    public GameResult guess(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        String result = judgement.compareNumber(computerNumbers, playerNumbers);
        boolean isGameWon = judgement.isGameWon(result);

        return new GameResult(result, isGameWon);
    }

    public List<Integer> generateNumbers() {
        return numberGenerator.generatorRandomNumber(RuleConstants.REQUIRED_LENGTH);
    }
}
