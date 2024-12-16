package org.gonza.javaplayground.baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
	private final List<Ball> ballList;

	public Balls(List<Integer> answerList) {
		this.ballList = convertToBallList(answerList);
	}

	private static List<Ball> convertToBallList(List<Integer> answerList) {
		List<Ball> ballList = new ArrayList<>();

		for (int i = 0; i < answerList.size(); i++) {
			ballList.add(new Ball(i + 1, answerList.get(i)));
		}
		return ballList;
	}

	public PlayResult play(List<Integer> targetBallList) {
		Balls targetBalls = new Balls(targetBallList);
		PlayResult playResult = new PlayResult();

		this.ballList.forEach(ball -> {
			BallStatus ballStatus = targetBalls.play(ball);
			playResult.report(ballStatus);
		});

		return playResult;
	}

	public BallStatus play(Ball targetBall) {
		return this.ballList.stream()
			.map(ball -> ball.play(targetBall))
			.filter(BallStatus::isNotNothing)
			.findFirst()
			.orElse(BallStatus.NOTHING);
	}
}
