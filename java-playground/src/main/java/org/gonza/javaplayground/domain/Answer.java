package org.gonza.javaplayground.domain;

import java.util.List;

public class Answer {

    private final List<Integer> answer;

    public Answer(List<Integer> answer) {
        this.answer = answer;
    }

    public List<Integer> findStrike(List<Integer> number) {
        Strike strike = new Strike();
        return strike.findIndices(answer, number);
    }

    public List<Integer> findBall(List<Integer> number) {
        Ball ball = new Ball();
        return ball.findIndices(answer, number);
    }
}
