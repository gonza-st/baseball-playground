package org.gonza.javaplayground.domain;

import org.assertj.core.api.Assertions;
import org.gonza.javaplayground.exception.InvalidLengthException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RuleTest {

    @Test
    void 입력한_값과_정답의_자릿수가_다르면_예외가_발생합니다() {
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> number = List.of(1, 2);
        Rule rule = new Rule();

        Assertions.assertThatThrownBy(() -> rule.validateLength(answer, number))
                .isInstanceOf(InvalidLengthException.class)
                .hasMessage("입력값과 정답의 자릿수가 일치하지 않습니다");
    }

}
