package org.gonza.javaplayground;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    public static final int FIRST_POSITION = 100;
    public static final int SECOND_POSITION = 10;
    public static final int CALIBRATE_NUMBER = 1;
    private final Random RANDOM = new Random();
    private final int NUMBER_RANGE = 9;

    @Override
    public BaseballGameNumber generate() {
        int first = generateFirstNumber();
        int second = generateSecondNumber();
        int third = RANDOM.nextInt(NUMBER_RANGE) + CALIBRATE_NUMBER;

        int number = first + second + third;

        return toBaseballGameNumber(number);
    }

    private BaseballGameNumber toBaseballGameNumber(int number) {
        try {
            return new BaseballGameNumber(number);
        } catch (Exception e) {
            return generate();
        }
    }

    private int generateFirstNumber() {
        return RANDOM.nextInt(NUMBER_RANGE) * FIRST_POSITION + CALIBRATE_NUMBER;
    }
    private int generateSecondNumber() {
        return RANDOM.nextInt(NUMBER_RANGE) * SECOND_POSITION + CALIBRATE_NUMBER;
    }
}
