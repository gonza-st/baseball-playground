package org.gonza.javaplayground;

public final class RuleConstants {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int REQUIRED_LENGTH = 3;

    private RuleConstants() {
        throw new AssertionError("StringUtil 클래스는 인스턴스화 할 수 없습니다.");
    }
}
