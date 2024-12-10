package org.gonza.javaplayground;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new FixNumberGenerator();
    }

    @DisplayName("숫자 야구 번호를 생성하면 BaseballGameNumber가 생성된다")
    @Test
    void generate() {
        BaseballGameNumber generatedNumber = numberGenerator.generate();

        BaseballGameNumber expectedValue = new BaseballGameNumber(123);
        assertThat(generatedNumber).isEqualTo(expectedValue);
    }
}
