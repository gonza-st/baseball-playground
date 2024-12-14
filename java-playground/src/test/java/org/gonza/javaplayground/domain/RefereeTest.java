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

}
