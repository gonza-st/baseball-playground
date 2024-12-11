package org.gonza.javaplayground.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StrikeTest {

    @Test
    void 해당_숫자가_스트라이크라면_스트라이크_숫자가_증가한다() {
        int[] numberList = {1,2,3};
        int answer = 123;
        Strike strike = new Strike();

        int firstCount = strike.judge(answer, numberList);
        int secondCount = strike.judge(answer, numberList);

        Assertions.assertThat(firstCount).isEqualTo(1);
        Assertions.assertThat(secondCount).isEqualTo(2);
    }
}