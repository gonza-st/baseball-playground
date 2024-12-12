package org.gonza.javaplayground.baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

class BallsTest {
	@Test
	void nothing() {
		Balls balls = new Balls(Lists.newArrayList(1, 2, 3));

		BallResult result = balls.play(new Ball(1, 4));

		assertEquals(result, BallResult.NOTHING);
	}

	@Test
	void ball() {
		Balls balls = new Balls(Lists.newArrayList(1, 2, 3));

		BallResult result = balls.play(new Ball(1, 3));

		assertEquals(result, BallResult.BALL);
	}

	@Test
	void strike() {
		Balls balls = new Balls(Lists.newArrayList(1, 2, 3));

		BallResult result = balls.play(new Ball(1, 1));

		assertEquals(result, BallResult.STRIKE);
	}
}