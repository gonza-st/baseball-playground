package org.gonza.javaplayground.ui;

import java.util.Scanner;

class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String inputNumber() {
        System.out.print("숫자를 입력해 주세요: ");
        return scanner.nextLine();
    }

    public String inputRestartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextLine();
    }
}
