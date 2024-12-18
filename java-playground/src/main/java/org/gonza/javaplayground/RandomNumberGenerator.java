package org.gonza.javaplayground;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    public static final int FIRST_POSITION = 100;
    public static final int SECOND_POSITION = 10;
    public static final int THIRD_POSITION = 1;
    public static final int CALIBRATE_NUMBER = 1;
    private final Random RANDOM = new Random();
    private final int NUMBER_RANGE = 9;

    @Override
    public BaseballGameNumber generate() {
        int first = generateNumber(FIRST_POSITION);
        int second = generateNumber(SECOND_POSITION);
        int third = generateNumber(THIRD_POSITION);

        int number = first + second + third;

        return toBaseballGameNumber(number);
    }

    private BaseballGameNumber toBaseballGameNumber(int number) {
        try {
            return new BaseballGameNumber(number);
        } catch (IllegalArgumentException e) {
            return generate();
        }
    }

    private int generateNumber(int position) {
        return RANDOM.nextInt(position) * position + CALIBRATE_NUMBER;
    }
}
