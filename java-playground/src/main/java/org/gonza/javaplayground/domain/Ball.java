package org.gonza.javaplayground.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Ball implements Result {

    @Override
    public List<Integer> findIndices(List<Integer> answer, List<Integer> number) {
        int START_INDEX = 0;
        return IntStream.range(START_INDEX, answer.size())
                .filter(i -> number.contains(answer.get(i)))
                .boxed()
                .toList();
    }

}
