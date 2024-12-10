package org.gonza.javaplayground;

import java.util.Scanner;

public class OutputView {

    public static void strikeBallView(int strikeCount, int ballCount) {
        if (strikeCount > 0 && ballCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            return;
        }
        if (strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
            return;
        }
        System.out.println(ballCount + "볼");
    }

    public static int gameResultView() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);

        int isContinue = scanner.nextInt();

        try {
            validate(isContinue);
        } catch (Exception e) {
            System.out.println("번호는 1, 2 중에서 입력하셔야 합니다");
            return gameResultView();
        }

        return isContinue;
    }

    private static void validate(int isContinueNumber) {
        if (isContinueNumber != 1 && isContinueNumber != 2) {
            throw new IllegalArgumentException();
        }
    }
}
