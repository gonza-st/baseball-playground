package org.gonza.javaplayground.core;

import java.util.List;

public class Judgement {

    public String compareNumber(Numbers computerNumbers, Numbers playerNumbers) {
        int correctCount = getPlaceHitCount(computerNumbers, playerNumbers);
        int strike = getStrikeCount(computerNumbers, playerNumbers);
        int ball = getBallCount(correctCount, strike);

        String result = getResult(correctCount, strike, ball);

        return result;
    }

    public boolean isGameWon(String result) {
        return result.equals(RuleConstants.REQUIRED_LENGTH + "스트라이크");
    }

    private String getResult(int correctCount, int strike, int ball) {
        if (correctCount == 0) {
            return "아웃";
        }

        if (strike == 0) {
            return ball + "볼";
        }

        if (ball == 0) {
            return strike + "스트라이크";
        }

        return ball + "볼 " + strike + "스트라이크";
    }

    private int getStrikeCount(Numbers computerNumberList, Numbers playerNumberList) {
        int strike = 0;

        for (int placeIndex = 0; placeIndex < playerNumberList.values().size(); placeIndex++) {
            if (hasNumberInPlace(computerNumberList.values(), placeIndex, playerNumberList.values().get(placeIndex))) {
                strike++;
            }
        }
        return strike;
    }

    private int getBallCount(int correctCount, int strike) {
        return correctCount - strike;
    }

    private int getPlaceHitCount(Numbers computerNumberList, Numbers playerNumberList) {
        int count = 0;
        for (int player : playerNumberList.values()) {
            if (computerNumberList.values().contains(player)) {
                count++;
            }
        }
        return count;
    }

    private boolean hasNumberInPlace(List<Integer> computers, int placeIndex, int number) {
        return computers.get(placeIndex) == number;
    }
}
