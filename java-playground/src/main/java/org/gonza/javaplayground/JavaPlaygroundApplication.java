package org.gonza.javaplayground;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaPlaygroundApplication {

	public static void main(String[] args) {
		// SpringApplication.run(JavaPlaygroundApplication.class, args);
		RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
		BaseballGame baseballGame = new BaseballGame(numberGenerator);

		int continueFlag = 1;
		while (continueFlag == 1) {
			baseballGame.init();
			baseballGameRun(baseballGame);
			continueFlag = InputView.inputRetryNumber();
		}
	}

	private static void baseballGameRun(BaseballGame baseballGame) {
		String retryNumber = InputView.inputNumber();
		BaseballGameNumber userNumber = new BaseballGameNumber(retryNumber);
		int strikeCount = baseballGame.getStrikeCount(userNumber);

		if (strikeCount == 3) {
			return;
		}

		int ballCount = baseballGame.getBallCount(userNumber);
		OutputView.strikeBallView(strikeCount, ballCount);
		baseballGameRun(baseballGame);
	}
}
