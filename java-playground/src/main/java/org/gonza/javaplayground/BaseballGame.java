package org.gonza.javaplayground;

import java.util.Objects;

public class BaseballGame {

    private NumberGenerator numberGenerator;
    private BaseballGameNumber correctNumber;

    public BaseballGame(NumberGenerator numberGenerator) {
        this(numberGenerator, null);
    }

    public BaseballGame(
        NumberGenerator numberGenerator,
        BaseballGameNumber correctNumber
    ) {
        this.numberGenerator = numberGenerator;
        this.correctNumber = correctNumber;
    }

    public void init() {
        correctNumber = numberGenerator.generate();
    }

    public int getStrikeCount(BaseballGameNumber userNumber) {
        return correctNumber.strikeCount(userNumber);
    }

    public int getBallCount(BaseballGameNumber userNumber) {
        return correctNumber.ballCount(userNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BaseballGame that))
            return false;
        return Objects.equals(numberGenerator, that.numberGenerator);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numberGenerator);
    }
}
