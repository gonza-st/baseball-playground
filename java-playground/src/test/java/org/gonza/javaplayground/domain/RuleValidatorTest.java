package org.gonza.javaplayground.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RuleValidatorTest {

    @Test
    void 입력한_값과_규칙의_자릿수가_다르면_예외가_발생합니다() {
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> number = List.of(1, 2);
    }
}
