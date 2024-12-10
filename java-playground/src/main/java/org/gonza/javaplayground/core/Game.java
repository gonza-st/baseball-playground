package org.gonza.javaplayground.core;

import org.gonza.javaplayground.util.Converter;
import org.gonza.javaplayground.view.Printer;
import org.gonza.javaplayground.view.Reader;

import java.util.List;

public class Game {
    private final NumberGenerator numberGenerator;
    private final Reader reader;
    private final Judgement judgement;
    private final Printer printer;

    public Game(NumberGenerator numberGenerator, Reader reader, Judgement judgement, Printer printer) {
        this.numberGenerator = numberGenerator;
        this.reader = reader;
        this.judgement = judgement;
        this.printer = printer;
    }

    public void play() {
        printer.print("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNumbers = numberGenerator.generatorRandomNumber(RuleConstants.REQUIRED_LENGTH);

        while (true) {
            try {
                printer.print("숫자를 입력해주세요 : ");
                String input = reader.read();
                List<Integer> playerNumbers = Converter.convertStringToNumberList(input);

                String result = judgement.compareNumber(computerNumbers, playerNumbers);
                printer.print(result);

                if (judgement.isGameWon(result)) {
                    printer.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    if (!askRetry()) {
                        break;
                    }
                    computerNumbers = numberGenerator.generatorRandomNumber(RuleConstants.REQUIRED_LENGTH);
                    printer.print("새로운 게임을 시작합니다.");
                }
            } catch (IllegalArgumentException e) {
                printer.print(e.getMessage());
            }
        }
    }

    private boolean askRetry() {
        printer.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        while (true) {
            try {
                String input = reader.readWithoutValidation();
                if (input.equals("1")) return true;
                if (input.equals("2")) return false;
                printer.print("1 또는 2만 입력 가능합니다.");
            } catch (IllegalArgumentException e) {
                printer.print("1 또는 2만 입력 가능합니다.");
            }
        }
    }
}
