package org.gonza.javaplayground.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class AnswerTest {

    @Test
    void 정답_숫자_중_스트라이크인_인덱스를_반환한다() {
        List<Integer> number = List.of(1, 2, 3);
        List<Integer> answerNumber = List.of(1, 2, 3);
        Answer answer = new Answer(answerNumber);

        List<Integer> strikeIndices = answer.findStrike(number);

        assertThat(strikeIndices).hasSize(3);
        assertThat(strikeIndices).containsExactly(0, 1, 2);
    }

    @Test
    void 정답_숫자_중_볼의_인덱스를_반환한다() {
        List<Integer> number = List.of(3, 1, 5);
        List<Integer> answerNumber = List.of(1, 2, 3);
        Answer answer = new Answer(answerNumber);

        List<Integer> ballIndices = answer.findBall(number);

        assertThat(ballIndices).hasSize(2);
        assertThat(ballIndices).containsExactly(0, 2);
    }
}
