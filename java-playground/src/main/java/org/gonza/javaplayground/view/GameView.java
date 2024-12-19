package org.gonza.javaplayground.view;

import org.gonza.javaplayground.util.Converter;

import java.util.List;

public class GameView {
    private final Reader reader;
    private final Printer printer;

    public GameView(Reader reader, Printer printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public void displayGameStart() {
        printer.print("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> getPlayerInput() {
        printer.print("숫자를 입력해주세요 : ");
        String input = reader.read();
        return Converter.convertStringToNumberList(input);
    }

    public void displayResult(String result) {
        printer.print(result);
    }

    public void displayWinMessage() {
        printer.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void displayNewGameMessage() {
        printer.print("새로운 게임을 시작합니다.");
    }

    public void displayError(String message) {
        printer.print(message);
    }

    public int getRetryChoice() {
        printer.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = reader.readWithoutValidation();
        return Integer.parseInt(input);
    }

    public void displayInvalidChoiceError() {
        printer.print("1 또는 2만 입력 가능합니다.");
    }
}
