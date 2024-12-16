package org.gonza.javaplayground.baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallTest {
    @Test
    @DisplayName("값이 다르면 NOTHING 이다")
    void nothing() {
        Ball ball = new Ball(1, 2);
        Ball target = new Ball(1, 3);

        BallStatus status = target.play(ball);

        assertEquals(status, BallStatus.NOTHING);
    }

    @Test
    @DisplayName("포지션이 다르고 값이 같으면 BALL 이다")
    void ball() {
        Ball ball = new Ball(2, 2);
        Ball target = new Ball(1, 2);

        BallStatus status = target.play(ball);

        assertEquals(status, BallStatus.BALL);
    }

    @Test
    @DisplayName("포지션이 같고 값이 같으면 STRIKE 이다")
    void strike() {
        Ball ball = new Ball(2, 2);
        Ball target = new Ball(2, 2);

        BallStatus status = target.play(ball);

        assertEquals(status, BallStatus.STRIKE);
    }
}