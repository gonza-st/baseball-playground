package org.gonza.javaplayground.core;

import org.gonza.javaplayground.view.GameView;

import java.util.List;

public class BaseballGameManager {
    private final BaseballGame game;
    private final GameView view;

    public BaseballGameManager(BaseballGameRule rule, GameView view) {
        this.game = new BaseballGame(rule);
        this.view = view;
    }

    public void run() {
        view.displayGameStart();
        startGameLoop();
    }

    private void startGameLoop() {
        while (true) {
            playRoundWithErrorHandling();
        }
    }

    private void playRoundWithErrorHandling() {
        try {
            playOneRound();
        } catch (IllegalArgumentException e) {
            view.displayError(e.getMessage());
        }
    }

    private void playOneRound() {
        List<Integer> playerNumbers = view.getPlayerInput();
        GameResult gameResult = game.guess(playerNumbers);
        view.displayResult(gameResult.result());

        if (!gameResult.isGameWon()) return;
        handleWin();
    }

    private void handleWin() {
        view.displayWinMessage();
        if (!shouldPlayAgain()) {
            exitGame();
        }
        startNewGame();
    }

    private void startNewGame() {
        game.restart();
        view.displayNewGameMessage();
    }

    private boolean shouldPlayAgain() {
        try {
            GameCommand command = getGameCommand();
            return command.isRestart();
        } catch (IllegalArgumentException e) {
            view.displayInvalidChoiceError();
            return shouldPlayAgain();
        }
    }

    private GameCommand getGameCommand() {
        int choice = view.getRetryChoice();
        return GameCommand.from(choice);
    }

    private void exitGame() {
        System.exit(0);
    }
}
