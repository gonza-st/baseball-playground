package org.gonza.javaplayground.domain;

import org.gonza.javaplayground.exception.InvalidLengthException;

import java.util.List;

public class Rule {

    public void validateLength(List<Integer> answer, List<Integer> number) {
        if (answer.size() != number.size()) {
            throw new InvalidLengthException("입력값과 정답의 자릿수가 일치하지 않습니다");
        }
    }

    public boolean completed(int size) {
        int MAX_SIZE = 3;
        return size == MAX_SIZE;
    }
}
