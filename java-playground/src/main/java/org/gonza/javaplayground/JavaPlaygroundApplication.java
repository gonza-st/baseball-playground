package org.gonza.javaplayground;

import org.gonza.javaplayground.core.Game;
import org.gonza.javaplayground.core.Judgement;
import org.gonza.javaplayground.core.NumberGenerator;
import org.gonza.javaplayground.view.ConsoleReader;
import org.gonza.javaplayground.view.Reader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class JavaPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaPlaygroundApplication.class, args);

        Scanner scanner = new Scanner(System.in);
        Reader reader = new ConsoleReader(scanner);
        NumberGenerator numberGenerator = new NumberGenerator();
        Judgement judgement = new Judgement();

        Game game = new Game(numberGenerator, reader, judgement);
        game.play();

        scanner.close();
    }

}
