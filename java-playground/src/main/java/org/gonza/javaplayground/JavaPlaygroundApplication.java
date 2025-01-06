package org.gonza.javaplayground;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaPlaygroundApplication {

	public static final int GAME_CONTINUE = 1;

	public static void main(String[] args) {
		// SpringApplication.run(JavaPlaygroundApplication.class, args);
		RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
		BaseballGame baseballGame = new BaseballGame(numberGenerator);

		int continueFlag = GAME_CONTINUE;
		while (continueFlag == GAME_CONTINUE) {
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
