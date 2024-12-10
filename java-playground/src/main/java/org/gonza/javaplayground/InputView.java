package org.gonza.javaplayground;

import java.util.Scanner;

public class InputView {

    public static String inputNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        return scanner.next();
    }
}
