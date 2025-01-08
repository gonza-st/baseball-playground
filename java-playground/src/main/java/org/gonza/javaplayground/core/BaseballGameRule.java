package org.gonza.javaplayground.core;

public class BaseballGameRule {
    private final NumberGenerator numberGenerator;
    private final Judgement judgement;

    public BaseballGameRule(NumberGenerator numberGenerator, Judgement judgement) {
        this.numberGenerator = numberGenerator;
        this.judgement = judgement;
    }

    public GameResult guess(Numbers computerNumbers, Numbers playerNumbers) {
        String result = judgement.compareNumber(computerNumbers, playerNumbers);
        boolean isGameWon = judgement.isGameWon(result);

        return new GameResult(result, isGameWon);
    }

    public Numbers generateNumbers() {
        return numberGenerator.generateRandomNumber(RuleConstants.REQUIRED_LENGTH);
    }
}
