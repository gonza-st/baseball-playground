package org.gonza.javaplayground.ui;

import org.gonza.javaplayground.domain.Result;

import java.util.List;

public class View {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public String requestInput() {
        return inputView.inputNumber();
    }

    public String restartOrExit() {
        return inputView.inputRestartOrExit();
    }

    public void printResult(List<Result> resultList) {
        outputView.printResult(resultList);
    }

    public void gameEnd() {
        outputView.printGameEnd();
    }
}
