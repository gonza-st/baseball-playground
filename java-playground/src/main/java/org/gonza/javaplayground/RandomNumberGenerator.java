package org.gonza.javaplayground;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    public static final int DEFAULT_POSITION = 10;
    public static final int CALIBRATE_NUMBER = 1;
    private final Random RANDOM = new Random();

    @Override
    public BaseballGameNumber generate(int digit) {
        int initPosition = DEFAULT_POSITION * digit;

        int number = 0;
        while (initPosition > 0) {
            number += generateNumber(initPosition);
            initPosition /= 10;
        }

        return toBaseballGameNumber(number, digit);
    }

    private BaseballGameNumber toBaseballGameNumber(int number, int digit) {
        try {
            return new BaseballGameNumber(number);
        } catch (IllegalArgumentException e) {
            return generate(digit);
        }
    }

    private int generateNumber(int position) {
        return RANDOM.nextInt(position) * position + CALIBRATE_NUMBER;
    }
}
