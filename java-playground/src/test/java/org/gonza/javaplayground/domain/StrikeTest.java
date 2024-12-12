package org.gonza.javaplayground.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StrikeTest {

    @Test
    void 해당_숫자가_스트라이크라면_결과는_참이다() {
        int[] number = {1, 2, 3};
        int[] answer = {1, 2, 3};
        Strike strike = new Strike();

        boolean isStrike = strike.correct(answer, number);

        assertThat(isStrike).isTrue();
    }

    @Test
    void 해당_숫자가_스트라이크가_아니라면_결과는_거짓이다() {
        int[] number = {1, 2, 3};
        int[] wrong = {9, 9, 9};
        Strike strike = new Strike();

        boolean isWrong = strike.correct(wrong, number);

        assertThat(isWrong).isFalse();
    }
}