package org.gonza.javaplayground.domain;

import org.gonza.javaplayground.exception.InvalidLengthException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RefereeTest {

    @Test
    void 입력한_값과_정답의_자릿수가_일치하지_않으면_예외가_발생합니다() {
        int number = 12;
        List<Integer> answerNumber = List.of(1, 2, 3);
        Answer answer = new Answer(answerNumber);
        Referee referee = new Referee();

        assertThatThrownBy(() -> referee.judge(answer, number))
                .isInstanceOf(InvalidLengthException.class);
    }

    @Test
    void 입력한_값이_모두_스트라이크라면_모든_결과_리스트는_스트라이크이다() {
        int number = 123;
        List<Integer> answerNumber = List.of(1, 2, 3);
        Answer answer = new Answer(answerNumber);
        Referee referee = new Referee();

        List<Result> resultList = referee.judge(answer, number);

        assertThat(resultList).hasSize(3);
        assertThat(resultList).allMatch(result -> result instanceof Strike);
    }

    @Test
    void 입력한_값이_모두_볼이라면_모든_결과_리스트는_볼이다() {
        int number = 123;
        List<Integer> answerNumber = List.of(3, 1, 2);
        Answer answer = new Answer(answerNumber);
        Referee referee = new Referee();

        List<Result> resultList = referee.judge(answer, number);

        assertThat(resultList).hasSize(3);
        assertThat(resultList).allMatch(result -> result instanceof Ball);
    }

}
