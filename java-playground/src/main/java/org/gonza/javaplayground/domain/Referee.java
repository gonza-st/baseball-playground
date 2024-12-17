package org.gonza.javaplayground.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Referee {

    private final Rule rule = new Rule();
    private final InputParser inputParser = new InputParser();
    private final List<Result> orderedResultTypeList = List.of(new Strike(), new Ball());

    public List<Result> judge(Answer answer, int number) {
        List<Integer> numberList = inputParser.parseToList(number);

        rule.validateLength(answer.getCorrectNumber(), numberList);

        List<Result> resultList = new ArrayList<>();
        List<Integer> currentAnswer = new ArrayList<>(answer.getCorrectNumber());
        List<Integer> currentNumber = new ArrayList<>(numberList);

        for (Result resultType : orderedResultTypeList) {
            List<Integer> indices = resultType.findIndices(currentAnswer, currentNumber);

            resultList.addAll(resultType.create(indices.size()));

            currentAnswer = extractNotStrike(indices, currentAnswer);
            currentNumber = extractNotStrike(indices, currentNumber);
        }

        return resultList;
    }

    public boolean isAllStrike(List<Result> resultList) {
        if (resultList.isEmpty()) {
            return false;
        }
        return resultList.stream().allMatch(result -> result instanceof Strike);
    }

    private List<Integer> extractNotStrike(List<Integer> strikeIndices, List<Integer> numberList) {
        int START_INDEX = 0;
        return IntStream.range(START_INDEX, numberList.size())
                .filter(index -> !strikeIndices.contains(index))
                .map(numberList::get)
                .boxed()
                .toList();
    }
}
