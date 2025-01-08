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
        Numbers computerNumbers = getComputerNumbersFromGame();

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
        Numbers originalNumbers = getComputerNumbersFromGame();

        // when
        game.restart();
        Numbers newNumbers = getComputerNumbersFromGame();

        // then
        assertThat(newNumbers).isNotEqualTo(originalNumbers);
    }

    @Test
    @DisplayName("부분적으로 맞추면 게임이 계속된다")
    void continueGameOnPartialMatch() {
        // given
        Numbers computerNumbers = getComputerNumbersFromGame();
        Numbers partialMatch = generatePartialMatch(computerNumbers);

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
        Numbers computerNumbers = getComputerNumbersFromGame();
        Numbers completelyDifferent = generateCompletelyDifferentNumbers(computerNumbers);

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
            Numbers numbers = getComputerNumbersFromGame();
            generatedNumbers.add(numbers.values());

            // then
            assertThat(numbers.values()).hasSize(3);
            assertThat(numbers.values()).doesNotHaveDuplicates();
            assertThat(numbers.values()).allMatch(n -> n >= 1 && n <= 9);
        }
        assertThat(generatedNumbers).hasSize(5);
    }

    private Numbers getComputerNumbersFromGame() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i != j && j != k && i != k) {
                        Numbers guess = new Numbers(Arrays.asList(i, j, k));
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

    private Numbers generatePartialMatch(Numbers numbers) {
        List<Integer> partial = new ArrayList<>(numbers.values());
        for (int i = 1; i <= 9; i++) {
            if (!numbers.values().contains(i)) {
                partial.set(0, i);
                break;
            }
        }
        return new Numbers(partial);
    }

    private Numbers generateCompletelyDifferentNumbers(Numbers numbers) {
        List<Integer> differentNumberList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (!numbers.values().contains(i)) {
                differentNumberList.add(i);
                if (differentNumberList.size() == 3) break;
            }
        }
        return new Numbers(differentNumberList);
    }
}
