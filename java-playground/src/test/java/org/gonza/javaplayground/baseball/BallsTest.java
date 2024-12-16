package org.gonza.javaplayground.baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

class BallsTest {
	@Test
	void _1_Ball_0_Strike() {
		Balls balls = new Balls(Lists.newArrayList(1, 2, 3));

		PlayResult result = balls.play(Lists.newArrayList(4, 5, 1));

		assertEquals(result.getStrike(), 0);
		assertEquals(result.getBall(), 1);
	}

	@Test
	void _3_Ball_0_Strike() {
		Balls balls = new Balls(Lists.newArrayList(1, 2, 3));

		PlayResult result = balls.play(Lists.newArrayList(2, 3, 1));

		assertEquals(result.getStrike(), 0);
		assertEquals(result.getBall(), 3);
	}

	@Test
	void _0_Ball_1_Strike() {
		Balls balls = new Balls(Lists.newArrayList(1, 2, 3));

		PlayResult result = balls.play(Lists.newArrayList(1, 4, 5));

		assertEquals(result.getStrike(), 1);
		assertEquals(result.getBall(), 0);
	}

	@Test
	void _2_Ball_1_Strike() {
		Balls balls = new Balls(Lists.newArrayList(1, 2, 3));

		PlayResult result = balls.play(Lists.newArrayList(1, 3, 2));

		assertEquals(result.getStrike(), 1);
		assertEquals(result.getBall(), 2);
	}

	@Test
	void _0_Ball_3_Strike() {
		Balls balls = new Balls(Lists.newArrayList(1, 2, 3));

		PlayResult result = balls.play(Lists.newArrayList(1, 2, 3));

		assertEquals(result.getStrike(), 3);
		assertEquals(result.getBall(), 0);
	}

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