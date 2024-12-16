package org.gonza.javaplayground.baseball;

public class PlayResult {
	private int ball = 0;
	private int strike = 0;

	public void report(BallResult ballResult) {
		if (ballResult.isBall()) {
			this.ball++;
		}

		if (ballResult.isStrike()) {
			this.strike++;
		}
	}

	public int getBall() {
		return this.ball;
	}

	public int getStrike() {
		return this.strike;
	}
}
