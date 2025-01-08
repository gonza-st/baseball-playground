package org.gonza.javaplayground.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputParserTest {

    @Test
    void 입력한_정수값이_정수_배열로_변환된다() {
        int number = 123;
        InputParser inputParser = new InputParser();

        List<Integer> numberList = inputParser.parseToList(number);

        assertThat(numberList).hasSize(3);
        assertThat(numberList).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void 입력한_문자열이_정수_배열로_반환된다() {
        String input = "123";
        InputParser inputParser = new InputParser();

        List<Integer> numberList = inputParser.parseToList(input);

        assertThat(numberList).hasSize(3);
        assertThat(numberList).isEqualTo(List.of(1, 2, 3));
    }
}
