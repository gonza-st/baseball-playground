package org.gonza.javaplayground;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BaseballGameNumberTest {

    @DisplayName("숫자야구 숫자의 값이 똑같다면 비교했을 때 같다고 나온다")
    @Test
    void create() {
        BaseballGameNumber baseballGameNumber1 = new BaseballGameNumber(123);
        BaseballGameNumber baseballGameNumber2 = new BaseballGameNumber(123);

        assertThat(baseballGameNumber1).isEqualTo(baseballGameNumber2);
    }

    @DisplayName("숫자의 길이는 세 자리이다")
    @Test
    void validateNumberLength() {
        int overLengthNumber = 1234;
        int underLengthNumber = 12;

        assertThatThrownBy(() -> new BaseballGameNumber(overLengthNumber))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BaseballGameNumber(underLengthNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자는 서로 중복될 수 없다")
    @ParameterizedTest
    @CsvSource({"111", "212", "133"})
    void validateDuplicateNumber(int duplicatedNumber) {
        assertThatThrownBy(() -> new BaseballGameNumber(duplicatedNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 값은 숫자여야 한다")
    @Test
    void createWithInputNumber() {
        assertThatThrownBy(() -> new BaseballGameNumber("12k"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자를 비교해서 스트라이크 개수를 반환한다")
    @Test
    void calculateStrikeCount() {
        BaseballGameNumber gameNumber = new BaseballGameNumber(123);
        BaseballGameNumber userNumber = new BaseballGameNumber(134);

        int result = gameNumber.strikeCount(userNumber);

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("숫자를 비교해서 볼 개수를 반환한다")
    @Test
    void calculateBallCount() {
        BaseballGameNumber gameNumber = new BaseballGameNumber(123);
        BaseballGameNumber userNumber = new BaseballGameNumber(132);

        int result = gameNumber.ballCount(userNumber);

        assertThat(result).isEqualTo(2);
    }
}
