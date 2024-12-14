package org.gonza.javaplayground.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class StrikeTest {

    @Test
    void 정답과_입력한_숫자가_스트라이크라면_일치하는_인덱스를_반환한다() {
        List<Integer> allMatched = List.of(1, 2, 3);
        List<Integer> oneMatched = List.of(1, 5, 5);
        List<Integer> twoMatched = List.of(1, 2, 5);
        List<Integer> betweenMatched = List.of(1, 5, 3);
        List<Integer> answer = List.of(1, 2, 3);
        Strike strike = new Strike();

        List<Integer> allMatchedIndices = strike.findIndices(answer, allMatched);
        List<Integer> oneMatchedIndices = strike.findIndices(answer, oneMatched);
        List<Integer> twoMatchedIndices = strike.findIndices(answer, twoMatched);
        List<Integer> betweenMatchedIndices = strike.findIndices(answer, betweenMatched);

        assertThat(allMatchedIndices).hasSize(3);
        assertThat(oneMatchedIndices).hasSize(1);
        assertThat(twoMatchedIndices).hasSize(2);
        assertThat(betweenMatchedIndices).hasSize(2);

        assertThat(allMatchedIndices).isEqualTo(List.of(0, 1, 2));
        assertThat(oneMatchedIndices).isEqualTo(List.of(0));
        assertThat(twoMatchedIndices).isEqualTo(List.of(0, 1));
        assertThat(betweenMatchedIndices).isEqualTo(List.of(0, 2));
    }

    @Test
    void 정답과_입력한_숫자가_스크라이크가_아니라면_일치하는_인덱스는_비어있다() {
        List<Integer> notMatched = List.of(9, 8, 7);
        List<Integer> answer = List.of(1, 2, 3);
        Strike strike = new Strike();

        List<Integer> notMatchedIndices = strike.findIndices(answer, notMatched);

        assertThat(notMatchedIndices).hasSize(0);
        assertThat(notMatchedIndices).isEmpty();
    }

    @Test
    void 입력한_사이즈에_맞는_스트라이크를_생성한다() {
        int size = 3;
        Strike strike = new Strike();

        List<Result> resultList = strike.create(size);

        assertThat(resultList).hasSize(3);
        assertThat(resultList).allMatch(result -> result instanceof Strike);
    }
}
