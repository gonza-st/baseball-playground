package org.gonza.javaplayground.domain;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Strike implements Result {

    @Override
    public List<Integer> findIndices(List<Integer> answer, List<Integer> number) {
        int START_INDEX = 0;
        return IntStream.range(START_INDEX, answer.size())
                .filter(i -> answer.get(i).equals(number.get(i)))
                .boxed()
                .toList();
    }

    @Override
    public List<Result> create(int size) {
        return Stream.generate(Strike::new)
                .limit(size)
                .map(strike -> (Result) strike)
                .toList();
    }

}
