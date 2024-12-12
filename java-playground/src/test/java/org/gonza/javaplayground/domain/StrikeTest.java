package org.gonza.javaplayground.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StrikeTest {

    @Test
    void 해당_숫자가_스트라이크라면_결과는_참이다() {
        int number = 123;
        int answer = 123;
        int wrong = 999;
        Strike strike = new Strike();

        boolean isStrike = strike.correct(answer, number);
        boolean isWrong = strike.correct(wrong, number);

        assertThat(isStrike).isTrue();
        assertThat(isWrong).isFalse();
    }
}