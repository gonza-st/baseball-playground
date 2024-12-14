package org.gonza.javaplayground.domain;

import java.util.Arrays;

public class Ball implements Result {
    @Override
    public boolean correct(int[] answer, int[] number) {
        return Arrays.stream(answer).
                anyMatch(value -> contains(number, value));
    }

    private boolean contains(int[] number, int value) {
        return Arrays.stream(number).
                anyMatch(num -> num == value);
    }
}
