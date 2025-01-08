package org.gonza.javaplayground;

import org.gonza.javaplayground.domain.*;
import org.gonza.javaplayground.ui.View;

public class Client {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        InputParser inputParser = new InputParser();
        View view = new View();
        Rule rule = new Rule();
        RuleValidator ruleValidator = new RuleValidator(rule);
        Referee referee = new Referee();
        Game game = new Game(
            numberGenerator,
            inputParser,
            view,
            rule,
            ruleValidator,
            referee
        );

        game.start();
    }
}
