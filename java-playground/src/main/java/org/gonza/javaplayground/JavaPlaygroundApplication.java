package org.gonza.javaplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class JavaPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaPlaygroundApplication.class, args);

        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();
        Reader reader = new ConsoleReader(scanner, validator);
        NumberGenerator numberGenerator = new NumberGenerator(validator);
        Judgement judgement = new Judgement();

        Game game = new Game(numberGenerator, reader, judgement);
        game.play();

        scanner.close();
    }

}
