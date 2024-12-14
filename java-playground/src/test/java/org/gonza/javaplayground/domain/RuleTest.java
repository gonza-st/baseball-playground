package org.gonza.javaplayground.domain;

import org.gonza.javaplayground.exception.InvalidLengthException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RuleTest {

    @Test
    void 입력한_값과_정답의_자릿수가_다르면_예외가_발생합니다() {
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> number = List.of(1, 2);
        Rule rule = new Rule();

        assertThatThrownBy(() -> rule.validateLength(answer, number))
                .isInstanceOf(InvalidLengthException.class)
                .hasMessage("입력값과 정답의 자릿수가 일치하지 않습니다");
    }

    @Test
    void 룰에_따라_값이_모두_끝났다면_결과는_참이다() {
        List<Integer> number = List.of(1, 2, 3);
        Rule rule = new Rule();

        boolean isCompleted = rule.completed(number.size());

        assertThat(isCompleted).isTrue();
    }

}
