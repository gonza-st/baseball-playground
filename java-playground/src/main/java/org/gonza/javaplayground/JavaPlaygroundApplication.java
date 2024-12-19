package org.gonza.javaplayground;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.gonza.javaplayground.baseball.Balls;
import org.gonza.javaplayground.baseball.PlayResult;
import org.gonza.javaplayground.util.NumberConverter;
import org.gonza.javaplayground.util.RandomNumberGenerator;
import org.gonza.javaplayground.util.Validator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaPlaygroundApplication {
	private static final Integer NUMBER_SIZE = 3;
	private static final Integer START_NUMBER = 3;
	private static final Integer END_NUMBER = 3;

	public static void main(String[] args) {
		Balls balls = new Balls(RandomNumberGenerator.generate(NUMBER_SIZE, START_NUMBER, END_NUMBER));
		boolean isStarted = true;

		while (isStarted) {
			System.out.print("숫자를 입력해 주세요 : ");
			Scanner scanner = new Scanner(System.in);
			List<Integer> numbers = NumberConverter.convertBy(scanner.nextLine());
			validate(numbers);

			PlayResult result = balls.play(numbers);
			isStarted = isStart(result);
			balls = getBalls(balls, isStarted, result);
		}

		System.out.println("게임 종료");
	}

	private static void validate(List<Integer> numbers) {
		if (!Validator.validSize(NUMBER_SIZE, numbers)) {
			throw new IllegalArgumentException("3글자를 입력해야 합니다.");
		}

		if (!Validator.validNotDuplicate(numbers)) {
			throw new IllegalArgumentException("중복되는 숫자를 입력할 수 없습니다.");
		}

		Stream<Integer> invalidNumber = numbers.stream().filter(n -> !Validator.validNumber(n));

		if (invalidNumber.findAny().isPresent()) {
			throw new IllegalArgumentException("숫자는 1 ~ 9 사이여야 합니다.");
		}
	}

	private static Balls getBalls(Balls balls, Boolean start, PlayResult result) {
		if (start && result.isGameEnd(END_NUMBER)) {
			balls = new Balls(RandomNumberGenerator.generate(3, 1, 9));
		}
		return balls;
	}

	private static boolean isStart(PlayResult result) {
		System.out.printf("%s 스트라이크 %s 볼%n", result.getStrike(), result.getBall());

		if (result.isGameEnd(END_NUMBER)) {
			System.out.println("정답입니다!");
			return isRestart();
		}

		return true;
	}

	private static boolean isRestart() {
		System.out.println("다시 시작하시겠습니까?");
		System.out.println("재시작 : 1");
		System.out.println("종료 : 2");
		Scanner scanner = new Scanner(System.in);

		if (scanner.nextLine().equals("1")) {
			return true;
		}

		if (scanner.nextLine().equals("2")) {
			return false;
		}

		System.out.println("잘못된 입력으로, 종료합니다.");
		return false;
	}
}
