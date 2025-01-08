package org.gonza.javaplayground.core;

import org.gonza.javaplayground.util.Validator;

import java.util.*;

public class NumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final Random random;

    public NumberGenerator() {
        this.random = new Random();
    }

    public Numbers generateRandomNumber(int size) {
        Validator.validateListSize(size);
        return new Numbers(generateUniqueNumbers(size));
    }

    private List<Integer> generateUniqueNumbers(int size) {
        Set<Integer> numberSet = new HashSet<>();

        while (numberSet.size() < size) {
            numberSet.add(random.nextInt(MAX_NUMBER) + MIN_NUMBER);
        }

        return new ArrayList<>(numberSet);
    }
}
