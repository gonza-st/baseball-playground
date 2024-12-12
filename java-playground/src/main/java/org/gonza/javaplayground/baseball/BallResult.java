package org.gonza.javaplayground.baseball;

public enum BallResult {
    BALL, STRIKE, NOTHING;

	public boolean isNotNothing() {
		return this != NOTHING;
	}
}
