package org.gonza.javaplayground.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StrikeTest {

    @Test
    void 해당_숫자가_스트라이크라면_결과는_참이다() {
        int number = 123;
        int answer = 123;
        Strike strike = new Strike();

        boolean isStrike = strike.correct(answer, number);

        assertThat(isStrike).isTrue();
    }

    @Test
    void 해당_숫자가_스트라이크가_아니라면_결과는_거짓이다() {
        int number = 123;
        int wrong = 999;
        Strike strike = new Strike();

        boolean isWrong = strike.correct(wrong, number);

        assertThat(isWrong).isFalse();
    }
}