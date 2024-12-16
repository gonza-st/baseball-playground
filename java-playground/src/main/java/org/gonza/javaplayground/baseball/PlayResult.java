package org.gonza.javaplayground.baseball;

public class PlayResult {
	private int ball = 0;
	private int strike = 0;

	public void report(BallStatus ballStatus) {
		if (ballStatus.isBall()) {
			this.ball++;
		}

		if (ballStatus.isStrike()) {
			this.strike++;
		}
	}

	public int getBall() {
		return this.ball;
	}

	public int getStrike() {
		return this.strike;
	}

	public boolean isGameEnd(Integer endNumber) {
		return endNumber == this.strike;
	}
}
