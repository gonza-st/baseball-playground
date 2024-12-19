package org.gonza.javaplayground.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgementTest {

    @Test
    @DisplayName("컴퓨터 숫자와 랜덤 숫자를 비교할 수 있다.")
    void compareNumberSuccessTest() throws Exception {

        //given
        Judgement judgement = getJudgement();
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> playerNumbers = List.of(1, 2, 3);

        //when
        String result = judgement.compareNumber(computerNumbers, playerNumbers);

        //then
        assertThat(result).isNotBlank();
        assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("숫자를 비교하여 자리X 숫자O면 볼을 반환한다.")
    void compareNumberSuccessTest_isBall() throws Exception {

        //given
        Judgement judgement = getJudgement();

        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> playerNumbers = List.of(4, 1, 5);

        //when
        String result = judgement.compareNumber(computerNumbers, playerNumbers);

        //then
        assertThat(result).isEqualTo("1볼");
    }

    @Test
    @DisplayName("숫자를 비교하여 자리O 숫자O면 스트라이크를 반환한다.")
    void compareNumberSuccessTest_isStrike() throws Exception {

        //given
        Judgement judgement = getJudgement();

        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> playerNumbers = List.of(1, 4, 5);

        //when
        String result = judgement.compareNumber(computerNumbers, playerNumbers);

        //then
        assertThat(result).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("숫자를 비교하여 스트라이크+볼 합쳐서 반환한다.")
    void compareNumberSuccessTest_isStrikeAndBall() throws Exception {

        //given
        Judgement judgement = getJudgement();

        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> playerNumbers = List.of(1, 3, 5);

        //when
        String result = judgement.compareNumber(computerNumbers, playerNumbers);

        //then
        assertThat(result).isEqualTo("1볼 1스트라이크");
    }

    private Judgement getJudgement() {
        Judgement judgement = new Judgement();
        return judgement;
    }
}
