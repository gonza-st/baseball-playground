package org.gonza.javaplayground.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameRuleTest {
    private BaseballGameRule baseballGameRule;

    @BeforeEach
    void setUp() {
        baseballGameRule = new BaseballGameRule(
                new NumberGenerator(),
                new Judgement()
        );
    }

    @Test
    @DisplayName("숫자를 정확히 맞추면 승리한다")
    void correctGuessResultsInWin() {
        // given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3);

        // when
        GameResult result = baseballGameRule.guess(computerNumbers, playerNumbers);

        // then
        assertThat(result.result()).isEqualTo("3스트라이크");
        assertThat(result.isGameWon()).isTrue();
    }

    @Test
    @DisplayName("스트라이크와 볼이 섞여있는 경우")
    void mixedStrikeAndBall() {
        // given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(1, 3, 2);

        // when
        GameResult result = baseballGameRule.guess(computerNumbers, playerNumbers);

        // then
        assertThat(result.result()).isEqualTo("2볼 1스트라이크");
        assertThat(result.isGameWon()).isFalse();
    }

    @Test
    @DisplayName("볼만 있는 경우")
    void onlyBalls() {
        // given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(3, 1, 2);

        // when
        GameResult result = baseballGameRule.guess(computerNumbers, playerNumbers);

        // then
        assertThat(result.result()).isEqualTo("3볼");
        assertThat(result.isGameWon()).isFalse();
    }

    @Test
    @DisplayName("숫자를 전혀 맞추지 못하면 아웃이 된다")
    void noMatchResultsInOut() {
        // given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(4, 5, 6);

        // when
        GameResult result = baseballGameRule.guess(computerNumbers, playerNumbers);

        // then
        assertThat(result.result()).isEqualTo("아웃");
        assertThat(result.isGameWon()).isFalse();
    }

    @Test
    @DisplayName("생성된 숫자는 1부터 9까지의 서로 다른 3개의 숫자이다")
    void generateValidNumbers() {
        // when
        List<Integer> numbers = baseballGameRule.generateNumbers();

        // then
        assertThat(numbers).hasSize(3);
        assertThat(numbers).doesNotHaveDuplicates();
        assertThat(numbers).allMatch(n -> n >= 1 && n <= 9);
    }

    @Test
    @DisplayName("생성된 숫자는 매번 다르다")
    void generateDifferentNumbers() {
        // when
        List<Integer> firstNumbers = baseballGameRule.generateNumbers();
        List<Integer> secondNumbers = baseballGameRule.generateNumbers();
        List<Integer> thirdNumbers = baseballGameRule.generateNumbers();

        // then
        List<List<Integer>> allGeneratedNumbers = Arrays.asList(firstNumbers, secondNumbers, thirdNumbers);
        assertThat(allGeneratedNumbers).doesNotHaveDuplicates();
    }
}
