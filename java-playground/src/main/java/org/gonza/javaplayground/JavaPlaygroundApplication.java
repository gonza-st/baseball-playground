package org.gonza.javaplayground;

import org.gonza.javaplayground.core.BaseballGameManager;
import org.gonza.javaplayground.core.BaseballGameRule;
import org.gonza.javaplayground.core.Judgement;
import org.gonza.javaplayground.core.NumberGenerator;
import org.gonza.javaplayground.view.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class JavaPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaPlaygroundApplication.class, args);

        Scanner scanner = new Scanner(System.in);
        Reader reader = new ConsoleReader(scanner);
        Printer printer = new ConsolePrinter();

        // 도메인
        NumberGenerator numberGenerator = new NumberGenerator();
        Judgement judgement = new Judgement();
        BaseballGameRule baseballGameRule = new BaseballGameRule(numberGenerator, judgement);

        // UI View
        GameView gameView = new GameView(reader, printer);

        // 게임 매니저 생성 및 실행
        BaseballGameManager baseballGameManager = new BaseballGameManager(baseballGameRule, gameView);
        baseballGameManager.run();

        scanner.close();

    }

}
