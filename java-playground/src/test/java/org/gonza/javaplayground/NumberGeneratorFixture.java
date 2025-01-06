package org.gonza.javaplayground;

public class NumberGeneratorFixture implements NumberGenerator {

    public static NumberGenerator getGenerator() {
        return new NumberGeneratorFixture();
    }

    @Override
    public BaseballGameNumber generate(int digit) {
        return new BaseballGameNumber(123);
    }
}
