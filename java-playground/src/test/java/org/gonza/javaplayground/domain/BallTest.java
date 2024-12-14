package org.gonza.javaplayground.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BallTest {

    @Test
    void 해당_숫자가_모두_일치하다면_결과는_참이다() {
        int[] correctNumber = {1, 2, 3};
        int[] answer = {1, 2, 3};
        Ball ball = new Ball();

        boolean isBall = ball.correct(answer, correctNumber);

        assertThat(isBall).isTrue();
    }

    @Test
    void 해당_숫자가_모두_일치하지_않다면_결과는_거짓이다() {
        int[] correctNumber = {1, 2, 3};
        int[] answer = {9, 9, 9};
        Ball ball = new Ball();

        boolean isBall = ball.correct(answer, correctNumber);

        assertThat(isBall).isFalse();
    }

    @Test
    void 해당_숫자의_위치가_달라도_값이_포함되면_결과는_참이다() {
        int[] correctNumber = {1, 2, 3};
        int[] answer = {3, 1, 2};
        Ball ball = new Ball();

        boolean isBall = ball.correct(answer, correctNumber);

        assertThat(isBall).isTrue();
    }
}
