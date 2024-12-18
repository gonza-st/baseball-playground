package org.gonza.javaplayground;

public class OutputView {

    public static void enterNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public static void strikeBallView(int strikeCount, int ballCount) {
        if (strikeCount > 0 && ballCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            return;
        }
        if (strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
            return;
        }
        if (ballCount > 0) {
            System.out.println(ballCount + "볼");
            return;
        }
        System.out.println("아웃");
    }

    public static void printSelectRetry() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void announceRetryException() {
        System.out.println("번호는 1, 2 중에서 입력하셔야 합니다");
    }
}
