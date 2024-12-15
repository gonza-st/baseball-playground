package org.gonza.javaplayground.domain;

import org.gonza.javaplayground.exception.DuplicateValueException;
import org.gonza.javaplayground.exception.ExceedsMaxLengthException;
import org.gonza.javaplayground.exception.InvalidLengthException;
import org.gonza.javaplayground.exception.NotNumberIncludedException;
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

    @Test
    void 입력한_값이_3자리_수를_초과한다면_예외가_발생한다() {
        List<Integer> number = List.of(1, 2, 3, 4);
        Rule rule = new Rule();

        assertThatThrownBy(() -> rule.validateMaxSize(number))
                .isInstanceOf(ExceedsMaxLengthException.class)
                .hasMessage("입력한 값이 3자리 수를 초과합니다");
    }

    @Test
    void 입력한_값_중_같은_값이_포함되어있다면_예외가_발생한다() {
        List<Integer> number = List.of(1, 2, 2);
        Rule rule = new Rule();

        assertThatThrownBy(() -> rule.validateDuplicateValue(number))
                .isInstanceOf(DuplicateValueException.class)
                .hasMessage("입력한 값 중 같은 값이 포함되어 있습니다");
    }

    @Test
    void 입력한_값_중에_숫자가_포함되어있지_않다면_예외가_발생한다() {
        String input1 ="12dk";
        String input2 = "12 ";
        String input3 = "12`";
        String input4 = "12+=";
        Rule rule = new Rule();

        assertThatThrownBy(() -> rule.validateNumber(input1))
                .isInstanceOf(NotNumberIncludedException.class)
                .hasMessage("입력한 값에 숫자가 포함되어있지 않습니다");

        assertThatThrownBy(() -> rule.validateNumber(input2))
                .isInstanceOf(NotNumberIncludedException.class)
                .hasMessage("입력한 값에 숫자가 포함되어있지 않습니다");

        assertThatThrownBy(() -> rule.validateNumber(input3))
                .isInstanceOf(NotNumberIncludedException.class)
                .hasMessage("입력한 값에 숫자가 포함되어있지 않습니다");

        assertThatThrownBy(() -> rule.validateNumber(input4))
                .isInstanceOf(NotNumberIncludedException.class)
                .hasMessage("입력한 값에 숫자가 포함되어있지 않습니다");
    }

}
