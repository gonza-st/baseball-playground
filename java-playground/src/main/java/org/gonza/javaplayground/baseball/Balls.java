package org.gonza.javaplayground.baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
	private final List<Ball> ballList;

	public Balls(ArrayList<Integer> answerList) {
		this.ballList = convertToBallList(answerList);
	}

	private static List<Ball> convertToBallList(ArrayList<Integer> answerList) {
		List<Ball> ballList = new ArrayList<>();

		for (int i = 0; i < answerList.size(); i++) {
			ballList.add(new Ball(i + 1, answerList.get(i)));
		}
		return ballList;
	}

	public PlayResult play(ArrayList<Integer> targetBallList) {
		Balls targetBalls = new Balls(targetBallList);
		PlayResult playResult = new PlayResult();

		this.ballList.forEach(ball -> {
			BallResult ballResult = targetBalls.play(ball);
			playResult.report(ballResult);
		});

		return playResult;
	}

	public BallResult play(Ball targetBall) {
		return this.ballList.stream()
			.map(ball -> ball.play(targetBall))
			.filter(BallResult::isNotNothing)
			.findFirst()
			.orElse(BallResult.NOTHING);
	}
}
