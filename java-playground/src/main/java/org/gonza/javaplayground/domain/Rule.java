package org.gonza.javaplayground.domain;

public class Rule {

    private final int requiredNumberSize;

    private final String RESTART_FLAG = "1";

    private final String EXIT_FLAG = "2";

    public Rule(int requiredNumberSize) {
        this.requiredNumberSize = requiredNumberSize;
    }

    public Rule() {
        this.requiredNumberSize = 3;
    }

    public boolean isOverNumberSize(int size) {
        return size > requiredNumberSize;
    }

    public boolean isBelowNumberSize(int size) {
        return size < requiredNumberSize;
    }

    public int getRequiredNumberSize() {
        return requiredNumberSize;
    }

    public boolean isRestart(String flag) {
        return flag.equals(RESTART_FLAG);
    }

    public boolean isExit(String flag) {
        return flag.equals(EXIT_FLAG);
    }
}
