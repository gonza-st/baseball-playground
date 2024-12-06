package org.gonza.javaplayground.core;

import java.util.List;

public class Judgement {

    public String compareNumber(List<Integer> computerNumberList, List<Integer> playerNumberList) {
        int correctCount = getPlaceHitCount(computerNumberList, playerNumberList);
        int strike = getStrikeCount(computerNumberList, playerNumberList);
        int ball = getBallCount(correctCount, strike);

        String result = getResult(correctCount, strike, ball);

        return result;
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

    private int getStrikeCount(List<Integer> computerNumberList, List<Integer> playerNumberList) {
        int strike = 0;

        for (int placeIndex = 0; placeIndex < playerNumberList.size(); placeIndex++) {
            if (hasNumberInPlace(computerNumberList, placeIndex, playerNumberList.get(placeIndex))) {
                strike++;
            }
        }
        return strike;
    }

    private int getBallCount(int correctCount, int strike) {
        return correctCount - strike;
    }

    private int getPlaceHitCount(List<Integer> computerNumberList, List<Integer> playerNumberList) {
        int count = 0;
        for (int player : playerNumberList) {
            if (computerNumberList.contains(player)) {
                count++;
            }
        }
        return count;
    }

    private boolean hasNumberInPlace(List<Integer> computers, int placeIndex, int number) {
        return computers.get(placeIndex) == number;
    }
}
