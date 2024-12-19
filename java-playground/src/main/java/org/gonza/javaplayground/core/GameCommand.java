package org.gonza.javaplayground.core;

import java.util.Arrays;

public enum GameCommand {
    RESTART(1),
    EXIT(2);

    private final int command;

    GameCommand(int command) {
        this.command = command;
    }

    public static GameCommand from(int input) {
        return Arrays.stream(values())
                .filter(command -> command.command == input)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("1 또는 2만 입력 가능합니다."));
    }

    public boolean isRestart() {
        return this == RESTART;
    }
}
