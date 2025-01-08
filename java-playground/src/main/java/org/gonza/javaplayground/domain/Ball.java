package org.gonza.javaplayground.domain;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ball implements Result {

    @Override
    public List<Integer> findIndices(List<Integer> answer, List<Integer> number) {
        int START_INDEX = 0;
        return IntStream.range(START_INDEX, answer.size())
                .filter(i -> number.contains(answer.get(i)))
                .boxed()
                .toList();
    }

    @Override
    public List<Result> create(int size) {
        return Stream.generate(Ball::new)
                .limit(size)
                .map(ball -> (Result) ball)
                .toList();
    }

    @Override
    public String toString() {
        return "볼";
    }

}
