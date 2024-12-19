package org.gonza.javaplayground.core;

import org.gonza.javaplayground.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public List<Integer> generatorRandomNumber(int size) {
        Validator.validateListSize(size);

        List<Integer> numberList = new ArrayList<>();
        Random random = new Random();

        while (numberList.size() < size) {
            int generatedNumber = random.nextInt(MAX_NUMBER) + MIN_NUMBER;
            if (!numberList.contains(generatedNumber)) {
                numberList.add(generatedNumber);
            }
        }
        return numberList;
    }
}
