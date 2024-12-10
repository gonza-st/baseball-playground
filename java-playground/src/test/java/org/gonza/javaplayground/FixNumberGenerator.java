package org.gonza.javaplayground;

public class FixNumberGenerator implements NumberGenerator {

    @Override
    public BaseballGameNumber generate() {
        return new BaseballGameNumber(123);
    }
}
