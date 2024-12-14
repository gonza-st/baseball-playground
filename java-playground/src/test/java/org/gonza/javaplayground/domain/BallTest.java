package org.gonza.javaplayground.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BallTest {

    @Test
    void 정답과_입력한_숫자가_볼이라면_일치하는_정답의_인덱스를_반환한다() {
        List<Integer> allMatched = List.of(1, 2, 3);
        List<Integer> oneMatched = List.of(2, 5, 5);
        List<Integer> twoMatched = List.of(3, 1, 5);
        List<Integer> answer = List.of(1, 2, 3);
        Ball ball = new Ball();

        List<Integer> allMatchedIndices = ball.findIndices(answer, allMatched);
        List<Integer> oneMatchedIndices = ball.findIndices(answer, oneMatched);
        List<Integer> twoMatchedIndices = ball.findIndices(answer, twoMatched);

        assertThat(allMatchedIndices).hasSize(3);
        assertThat(oneMatchedIndices).hasSize(1);
        assertThat(twoMatchedIndices).hasSize(2);

        assertThat(allMatchedIndices).isEqualTo(List.of(0, 1, 2));
        assertThat(oneMatchedIndices).isEqualTo(List.of(1));
        assertThat(twoMatchedIndices).isEqualTo(List.of(0, 2));
    }

    @Test
    void 정답과_입력한_숫자가_볼이_아니라면_인덱스는_비어있다() {
        List<Integer> notMatched = List.of(9, 8, 7);
        List<Integer> answer = List.of(1, 2, 3);
        Ball ball = new Ball();

        List<Integer> notMatchedIndices = ball.findIndices(answer, notMatched);

        assertThat(notMatchedIndices).hasSize(0);
        assertThat(notMatchedIndices).isEmpty();
    }
}
