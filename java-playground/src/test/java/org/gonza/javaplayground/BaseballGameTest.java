package org.gonza.javaplayground;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballGameTest {

    @DisplayName("숫자 생성기를 받아서 숫자 야구 게임을 생성한다")
    @Test
    void createWithNumberGenerator() {
        FixNumberGenerator numberGenerator = new FixNumberGenerator();
        BaseballGame baseballGame1 = new BaseballGame(numberGenerator);
        BaseballGame baseballGame2 = new BaseballGame(numberGenerator);

        assertThat(baseballGame1).isEqualTo(baseballGame2);
    }

    @DisplayName("게임을 시작하면 정답 번호가 생성된다")
    @Test
    void gameStart() {
        FixNumberGenerator numberGenerator = new FixNumberGenerator();
        BaseballGame baseballGame = new BaseballGame(numberGenerator);
        baseballGame.init();

        BaseballGame expected = new BaseballGame(numberGenerator, new BaseballGameNumber(123));

        assertThat(baseballGame).isEqualTo(expected);
    }
}
