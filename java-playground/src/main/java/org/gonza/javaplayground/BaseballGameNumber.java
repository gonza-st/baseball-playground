package org.gonza.javaplayground;

import java.util.Objects;
import java.util.stream.IntStream;

public class BaseballGameNumber {

    public static final int NUMBER_MAX_RANGE = 999;
    public static final int NUMBER_MIN_RANGE = 100;
    public static final int NUMBER_LENGTH = 3;
    private int number;

    public BaseballGameNumber(String inputNumber) {
        this(toNumber(inputNumber));
    }

    public BaseballGameNumber(int number) {
        if (number > NUMBER_MAX_RANGE || number < NUMBER_MIN_RANGE) {
            throw new IllegalArgumentException();
        }
        if (isDuplicatedNumber(number)) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public int strikeCount(BaseballGameNumber userNumber) {
        return userNumber.calculateStrikeCount(this.number);
    }

    public int ballCount(BaseballGameNumber userNumber) {
        return userNumber.calculateBallCount(this.number);
    }

    private int calculateStrikeCount(int number) {
        int count = 0;
        String userNumber = String.valueOf(this.number);
        String gameNumber = String.valueOf(number);

        for (int i=0; i<NUMBER_LENGTH; i++) {
            count += compareNumbers(userNumber.charAt(i), gameNumber.charAt(i));
        }
        return count;
    }

    private int calculateBallCount(int number) {
        String userNumber = String.valueOf(this.number);
        String gameNumber = String.valueOf(number);

        return (int) IntStream.range(0, NUMBER_LENGTH)
            .filter(i -> userNumber.charAt(i) != gameNumber.charAt(i))
            .filter(i -> gameNumber.contains(String.valueOf(userNumber.charAt(i))))
            .count();
    }

    private int compareNumbers(char first, char second) {
        if (first == second) {
            return 1;
        }
        return 0;
    }

    private boolean isDuplicatedNumber(int number) {
        String stringNumber = String.valueOf(number);

        return stringNumber.chars()
            .distinct()
            .count() != NUMBER_LENGTH;
    }

    private static int toNumber(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BaseballGameNumber that))
            return false;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return "BaseballGameNumber{" +
            "number=" + number +
            '}';
    }
}
