package org.gonza.javaplayground.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {
    private BaseballGame game;
    private BaseballGameRule rule;

    @BeforeEach
    void setUp() {
        rule = new BaseballGameRule(new NumberGenerator(), new Judgement());
        game = new BaseballGame(rule);
    }

    @Test
    @DisplayName("숫자를 맞추면 승리한다")
    void winWhenGuessCorrectly() {
        // given
        List<Integer> computerNumbers = getComputerNumbersFromGame();

        // when
        GameResult result = game.guess(computerNumbers);

        // then
        assertThat(result.result()).isEqualTo("3스트라이크");
        assertThat(result.isGameWon()).isTrue();
    }

    @Test
    @DisplayName("재시작하면 새로운 숫자를 생성한다")
    void generateNewNumbersOnRestart() {
        // given
        List<Integer> originalNumbers = getComputerNumbersFromGame();

        // when
        game.restart();
        List<Integer> newNumbers = getComputerNumbersFromGame();

        // then
        assertThat(newNumbers).isNotEqualTo(originalNumbers);
    }

    @Test
    @DisplayName("부분적으로 맞추면 게임이 계속된다")
    void continueGameOnPartialMatch() {
        // given
        List<Integer> computerNumbers = getComputerNumbersFromGame();
        List<Integer> partialMatch = generatePartialMatch(computerNumbers);

        // when
        GameResult result = game.guess(partialMatch);

        // then
        assertThat(result.isGameWon()).isFalse();
        assertThat(result.result()).contains("스트라이크");
    }

    @Test
    @DisplayName("전혀 다른 숫자를 입력하면 아웃이 된다")
    void getOutOnCompletelyDifferentNumbers() {
        // given
        List<Integer> computerNumbers = getComputerNumbersFromGame();
        List<Integer> completelyDifferent = generateCompletelyDifferentNumbers(computerNumbers);

        // when
        GameResult result = game.guess(completelyDifferent);

        // then
        assertThat(result.result()).isEqualTo("아웃");
        assertThat(result.isGameWon()).isFalse();
    }

    @Test
    @DisplayName("여러 번의 재시작에도 유효한 숫자가 생성된다")
    void generateValidNumbersAfterMultipleRestarts() {
        // when
        Set<List<Integer>> generatedNumbers = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            game.restart();
            List<Integer> numbers = getComputerNumbersFromGame();
            generatedNumbers.add(numbers);

            // then
            assertThat(numbers).hasSize(3);
            assertThat(numbers).doesNotHaveDuplicates();
            assertThat(numbers).allMatch(n -> n >= 1 && n <= 9);
        }
        assertThat(generatedNumbers).hasSize(5);
    }

    // 테스트 헬퍼 메서드들
    private List<Integer> getComputerNumbersFromGame() {
        // 컴퓨터의 숫자를 알아내기 위한 모든 가능한 조합 시도
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i != j && j != k && i != k) {
                        List<Integer> guess = Arrays.asList(i, j, k);
                        GameResult result = game.guess(guess);
                        if (result.isGameWon()) {
                            return guess;
                        }
                    }
                }
            }
        }
        throw new IllegalStateException("컴퓨터 숫자를 찾을 수 없습니다");
    }

    private List<Integer> generatePartialMatch(List<Integer> numbers) {
        // 한 자리만 다른 숫자 생성
        List<Integer> partial = new ArrayList<>(numbers);
        for (int i = 1; i <= 9; i++) {
            if (!numbers.contains(i)) {
                partial.set(0, i);
                break;
            }
        }
        return partial;
    }

    private List<Integer> generateCompletelyDifferentNumbers(List<Integer> numbers) {
        List<Integer> different = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (!numbers.contains(i)) {
                different.add(i);
                if (different.size() == 3) break;
            }
        }
        return different;
    }
}
