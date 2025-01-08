package org.gonza.javaplayground.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberGeneratorTest {
    private NumberGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new NumberGenerator();
    }

    @Test
    @DisplayName("랜덤 숫자를 요청 사이즈에 맞게 생성한다.")
    void generateRandomNumberSuccessTest() throws Exception {

        //given
        int requestSize = 3;

        //when
        Numbers generatedNumber = generator.generateRandomNumber(requestSize);

        //then
        assertThat(generatedNumber.values()).hasSize(requestSize);
        assertThat(generatedNumber.values()).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("잘못된 크기를 입력하면 예외가 발생한다.")
    void generateRandomNumberFailTest_invalidSize() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> generator.generateRandomNumber(0)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> generator.generateRandomNumber(10))
        );
    }
}
