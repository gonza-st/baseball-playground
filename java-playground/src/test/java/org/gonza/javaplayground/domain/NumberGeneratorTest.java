package org.gonza.javaplayground.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberGeneratorTest {

    @Test
    void 생성된_숫자의_길이는_3입니다() {
        NumberGenerator numberGenerator = new NumberGenerator();

        int number = numberGenerator.generate();
        int length = String.valueOf(number).length();

        assertThat(length).isEqualTo(3);
    }

    @Test
    void 생성된_숫자의_한자리는_0이되면_안됩니다() {
        NumberGenerator numberGenerator = new NumberGenerator();

        int number = numberGenerator.generate();
        String numberString = String.valueOf(number);

        assertThat(numberString).doesNotContain("0");
    }

    @Test
    void 생성된_숫자의_각_숫자는_모두_달라야합니다() {
        NumberGenerator numberGenerator = new NumberGenerator();

        int number = numberGenerator.generate();
        String numberString = String.valueOf(number);

        long uniqueCount = numberString.chars().distinct().count();

        assertThat(uniqueCount).isEqualTo(3);
    }

    @Test
    void 생성된_숫자는_생성할_때마다_달라야합니다() {
        NumberGenerator numberGenerator = new NumberGenerator();

        int number1 = numberGenerator.generate();
        int number2 = numberGenerator.generate();

        assertThat(number1).isNotEqualTo(number2);
    }
}
