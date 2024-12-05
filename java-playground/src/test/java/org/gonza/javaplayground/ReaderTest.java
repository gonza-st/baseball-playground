package org.gonza.javaplayground;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReaderTest {
    private Validator validator;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    @DisplayName("사용자로부터 입력을 받을 수 있다.")
    void inputByUserSuccessTest() throws Exception {

        //given
        ConsoleReader reader = createReader("123");

        //when
        String expect = reader.read();

        //then
        Assertions.assertThat(expect).isEqualTo("123");
    }

    @DisplayName("입력 받은 값이 숫자가 아닐시 예외")
    @CsvSource({
            "abc",
            "!@#",
            "한글",
            "abc123",
            "' '"
    })
    @ParameterizedTest
    void inputByUserFailTest_inputNotNumber(String invalidInput) throws Exception {
        //given
        ConsoleReader reader = createReader(invalidInput);

        //when & then
        assertThrows(IllegalArgumentException.class, () -> reader.read());
    }

    @DisplayName("입력 받은 숫자가 3자리가 아닐시 예외")
    @CsvSource({
            "1234",
            "12345",
            "16",
            "1",
    })
    @ParameterizedTest
    void inputByUserFailTest_inputNumberIsNotThreeDigits(String invalidInput) throws Exception {
        //given
        ConsoleReader reader = createReader(invalidInput);

        //when & then
        assertThrows(IllegalArgumentException.class, () -> reader.read());
    }

    @DisplayName("입력 받은 숫자에 중복이 있을시 예외")
    @CsvSource({
            "223",
            "111",
            "323",
    })
    @ParameterizedTest
    void inputByUserFailTest_inputNumberIsDuplicate(String invalidInput) throws Exception {
        //given
        ConsoleReader reader = createReader(invalidInput);

        //when & then
        assertThrows(IllegalArgumentException.class, () -> reader.read());
    }

    private ConsoleReader createReader(String input) {
        scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        return new ConsoleReader(scanner, validator);
    }
}
