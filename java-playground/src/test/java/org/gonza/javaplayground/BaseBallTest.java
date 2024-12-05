package org.gonza.javaplayground;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class BaseBallTest {

    @Test
    @DisplayName("사용자로부터 입력을 받을 수 있다.")
    void inputByUserSuccessTest() throws Exception {

        //given
        Scanner scanner = new Scanner(new ByteArrayInputStream("123".getBytes()));
        ConsoleReader reader = new ConsoleReader(scanner);

        //when
        String expect = reader.read();

        //then
        Assertions.assertThat(expect).isEqualTo("123");
    }
}
