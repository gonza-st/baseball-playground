package org.gonza.javaplayground.core;

import org.gonza.javaplayground.util.Converter;
import org.gonza.javaplayground.view.Reader;

import java.util.List;

public class Game {
    private final NumberGenerator numberGenerator;
    private final Reader reader;
    private final Judgement judgement;

    public Game(NumberGenerator numberGenerator, Reader reader, Judgement judgement) {
        this.numberGenerator = numberGenerator;
        this.reader = reader;
        this.judgement = judgement;
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNumbers = numberGenerator.generatorRandomNumber(RuleConstants.REQUIRED_LENGTH);

        while (true) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                String input = reader.read();
                List<Integer> playerNumbers = Converter.convertStringToNumberList(input);

                String result = judgement.compareNumber(computerNumbers, playerNumbers);
                System.out.println(result);

                if (isGameWon(result)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    if (!askRetry()) {
                        break;
                    }
                    computerNumbers = numberGenerator.generatorRandomNumber(RuleConstants.REQUIRED_LENGTH);
                    System.out.println("새로운 게임을 시작합니다.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // TODO -> 심판으로 옮겨도 될 듯?
    private boolean isGameWon(String result) {
        return result.equals(RuleConstants.REQUIRED_LENGTH + "스트라이크");
    }

    // TODO -> Printer? 같은 클래스를 만들어 옮겨볼까?
    private boolean askRetry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        while (true) {
            try {
                String input = reader.readWithoutValidation();
                if (input.equals("1")) return true;
                if (input.equals("2")) return false;
                System.out.println("1 또는 2만 입력 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("1 또는 2만 입력 가능합니다.");
            }
        }
    }
}
