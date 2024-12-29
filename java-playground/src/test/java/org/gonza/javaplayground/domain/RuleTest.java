package org.gonza.javaplayground.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RuleTest {

    @Test
    void 재시작_플래그를_입력하면_재시작_여부_결과가_참이다() {
        String restartFlag = "1";
        Rule rule = new Rule();

        boolean isRestart = rule.isRestart(restartFlag);

        assertThat(isRestart).isTrue();
    }

    @Test
    void 재시작_플래그가_아닌_값을_입력하면_재시작_여부_결과가_거짓이다() {
        String anyFlag = "9";
        Rule rule = new Rule();

        boolean isAnyFlag = rule.isRestart(anyFlag);

        assertThat(isAnyFlag).isFalse();
    }

    @Test
    void 게임종료_플래그를_입력하면_게임종료_결과가_참이다() {
        String exitFlag = "2";
        Rule rule = new Rule();

        boolean isExit = rule.isExit(exitFlag);

        assertThat(isExit).isTrue();
    }

    @Test
    void 게임종료_플래그가_아닌_다른값을_입력하면_게임종료_결과가_거짓이다() {
        String anyFlag = "9";
        Rule rule = new Rule();

        boolean isAnyFlag = rule.isExit(anyFlag);

        assertThat(isAnyFlag).isFalse();
    }

    @Test
    void 입력한_값이_최대_사이즈를_초과했다면_결과는_참이다() {
        List<Integer> number = List.of(1, 2, 3, 4);
        int maxSize = 3;
        Rule rule = new Rule(maxSize);

        boolean isOverMaxSize = rule.isOverNumberSize(number.size());

        assertThat(isOverMaxSize).isTrue();
    }

    @Test
    void 입력한_값이_최대_사이즈_미만이라면_결과는_참이다() {
        List<Integer> number = List.of(1, 2);
        int maxSize = 3;
        Rule rule = new Rule(maxSize);

        boolean isBelowMaxSize = rule.isBelowNumberSize(number.size());

        assertThat(isBelowMaxSize).isTrue();
    }
}
