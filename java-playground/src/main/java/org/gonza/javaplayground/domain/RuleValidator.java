package org.gonza.javaplayground.domain;

import org.gonza.javaplayground.exception.*;

import java.util.List;

public class RuleValidator {
    private final Rule rule;

    public RuleValidator(Rule rule) {
        this.rule = rule;
    }

    public void validateLength(List<Integer> answer, List<Integer> number) {
        if (answer.size() != number.size()) {
            throw new InvalidLengthException("입력값과 정답의 자릿수가 일치하지 않습니다");
        }
    }

    public void validateMaxSize(List<Integer> number) {
        int inputSize = number.size();
        if (rule.isOverNumberSize(inputSize) || rule.isBelowNumberSize(inputSize)) {
            throw new InvalidNumberLengthException("입력한 값이 3자리수가 아닙니다.");
        }
    }

    public void validateDuplicateValue(List<Integer> number) {
        long uniqueCount = number.stream().distinct().count();

        if (uniqueCount != number.size()) {
            throw new DuplicateValueException("입력한 값 중 같은 값이 포함되어 있습니다");
        }
    }

    public void validateNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new NotNumberIncludedException("입력한 값에 숫자가 포함되어있지 않습니다");
        }
    }
}
