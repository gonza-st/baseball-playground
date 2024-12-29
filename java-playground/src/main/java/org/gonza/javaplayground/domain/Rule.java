package org.gonza.javaplayground.domain;

import org.gonza.javaplayground.exception.*;

import java.util.List;

public class Rule {

    private final int requiredNumberSize;

    private final String RESTART_FLAG = "1";

    private final String EXIT_FLAG = "2";

    public Rule(int requiredNumberSize) {
        this.requiredNumberSize = requiredNumberSize;
    }

    public Rule() {
        this.requiredNumberSize = 3;
    }

    public void validateEqualLengths(List<Integer> answer, List<Integer> number) {
        if (answer.size() != number.size()) {
            throw new InvalidLengthException("입력값과 정답의 자릿수가 일치하지 않습니다");
        }
    }

    public void validateRequiredSize(List<Integer> number) {
        if (number.size() != requiredNumberSize) {
            throw new InvalidNumberLengthException("입력한 값이 3자리수가 아닙니다.");
        }
    }

    public void validateDuplicateValue(List<Integer> number) {
        long uniqueCount = number.stream().distinct().count();

        if (uniqueCount != number.size()) {
            throw new DuplicateValueException("입력한 값 중 같은 값이 포함되어 있습니다");
        }
    }

    public void validateNumericInput(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new NotNumberIncludedException("입력한 값에 숫자가 포함되어있지 않습니다");
        }
    }

    public void validateRestartOrExitFlag(String input) {
        if (!input.equals(RESTART_FLAG) && !input.equals(EXIT_FLAG)) {
            throw new InvalidRestartOrExitFlagException("1 혹은 2 중에 입력해주세요");
        }
    }

    public boolean isOverNumberSize(int size) {
        return size > requiredNumberSize;
    }

    public boolean isBelowNumberSize(int size) {
        return size < requiredNumberSize;
    }

    public int getRequiredNumberSize() {
        return requiredNumberSize;
    }

    public Boolean isRestart(String flag) {
        return flag.equals(RESTART_FLAG);
    }

    public String getExitFlag() {
        return EXIT_FLAG;
    }
}
