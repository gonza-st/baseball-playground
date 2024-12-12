package org.gonza.javaplayground.domain;

import java.util.stream.IntStream;

public class Strike implements Result {

    @Override
    public boolean correct(int[] answer, int[] number) {
        return IntStream.range(0, answer.length)
                .anyMatch(i -> answer[i] == number[i]);
    }
}
