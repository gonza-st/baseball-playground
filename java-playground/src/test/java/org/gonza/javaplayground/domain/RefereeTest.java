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

    @Test
    void 입력한_모든_값이_스트라이크_라면_결과는_참이다() {
        List<Result> resultList = List.of(new Strike(), new Strike(), new Strike());
        Referee referee = new Referee();

        boolean isAllStrike = referee.isAllStrike(resultList);

        assertThat(isAllStrike).isTrue();
    }

    @Test
    void 입력한_값_중_하나라도_스트라이크가_아니라면_결과는_거짓이다() {
        List<Result> resultList = List.of(new Ball(), new Strike(), new Strike());
        Referee referee = new Referee();

        boolean isAllStrike = referee.isAllStrike(resultList);

        assertThat(isAllStrike).isFalse();
    }

    @Test
    void 입력한_값_중_검증된_값은_제외한후_검증을_해야한다() {
        int oneStrike1 = 123;
        int oneStrike2 = 129;
        int oneStrikeOneBall = 156;
        List<Integer> answerNumber = List.of(1, 4, 5);
        Answer answer = new Answer(answerNumber);
        Referee referee = new Referee();

        List<Result> resultList1 = referee.judge(answer, oneStrike1);
        List<Result> resultList2 = referee.judge(answer, oneStrike2);
        List<Result> resultList3 = referee.judge(answer, oneStrikeOneBall);

        assertThat(resultList1).hasSize(1);
        assertThat(resultList1).allMatch(result -> result instanceof Strike);

        assertThat(resultList2).hasSize(1);
        assertThat(resultList2).allMatch(result -> result instanceof Strike);

        assertThat(resultList3).hasSize(2);
        assertThat(resultList3.getFirst()).isInstanceOf(Strike.class);
        assertThat(resultList3.get(1)).isInstanceOf(Ball.class);
    }

}
