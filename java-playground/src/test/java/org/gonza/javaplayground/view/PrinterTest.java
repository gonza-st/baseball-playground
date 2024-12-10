package org.gonza.javaplayground.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PrinterTest {

    @Test
    @DisplayName("콘솔에 값이 출력 된다.")
    void printSuccessTest() throws Exception {

        //given
        String content = "content";
        Printer printer = new ConsolePrinter();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //when
        printer.print(content);

        //then
        String actual = outputStream.toString().trim();
        assertThat(actual).isEqualTo(content);
    }
}
