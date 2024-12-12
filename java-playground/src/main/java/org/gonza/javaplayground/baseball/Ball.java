package org.gonza.javaplayground.baseball;

public class Ball {
    private final int position;
    private final int number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public BallResult play(Ball ball) {
        if (ball.position == this.position && ball.number == this.number) {
            return BallResult.STRIKE;
        }

        if (ball.number == this.number) {
            return BallResult.BALL;
        }

        return BallResult.NOTHING;
    }
}
