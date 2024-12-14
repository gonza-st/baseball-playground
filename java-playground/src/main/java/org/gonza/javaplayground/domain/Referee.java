package org.gonza.javaplayground.domain;

import java.util.List;

public class Referee {

    public List<Result> judge(Answer answer, int number) {
        Rule rule = new Rule();
        InputParser inputParser = new InputParser();
        List<Integer> numberList = inputParser.parseToList(number);

        rule.validateLength(answer.getCorrectNumber(), numberList);

        return List.of();
    }
}
