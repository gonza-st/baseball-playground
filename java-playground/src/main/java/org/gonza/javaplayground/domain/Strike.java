package org.gonza.javaplayground.domain;

import java.util.Arrays;

public class Strike implements Result {

    @Override
    public boolean correct(int[] answer, int[] number) {
        return Arrays.equals(answer, number);
    }
}
