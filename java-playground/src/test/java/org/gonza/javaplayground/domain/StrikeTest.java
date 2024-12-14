package org.gonza.javaplayground.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StrikeTest {

    @Test
    void 해당_숫자가_모두_일치하다면_결과는_참이다() {
        int[] correctNumber = {1, 2, 3};
        int[] answer = {1, 2, 3};
        Strike strike = new Strike();

        boolean isStrike = strike.correct(answer, correctNumber);

        assertThat(isStrike).isTrue();
    }

    @Test
    void 해당_숫자가_모두_일치하지_않다면_결과는_거짓이다() {
        int[] wrongNumber = {1, 2, 3};
        int[] answer = {9, 9, 9};
        Strike strike = new Strike();

        boolean isWrong = strike.correct(answer, wrongNumber);

        assertThat(isWrong).isFalse();
    }

    @Test
    void 해당_숫자의_위치가_동일하면서_값도_일치한다면_결과는_참이다() {
        int[] number = {1, 2, 3};
        int[] answer = {1, 4, 4};
        Strike strike = new Strike();

        boolean isStrike = strike.correct(answer, number);

        assertThat(isStrike).isTrue();
    }

    @Test
    void 해당_숫자의_위치가_같지않지만_값이_일치할경우_결과는_거짓이다() {
        int[] number = {1, 2, 3};
        int[] answer = {3, 5, 1};
        Strike strike = new Strike();

        boolean isStrike = strike.correct(answer, number);

        assertThat(isStrike).isFalse();
    }
}
