package org.gonza.javaplayground;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public List<Integer> generatorRandomNumber(int size) {
        validateSize(size);

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

    private void validateSize(int size) {
        if (size < MIN_NUMBER || size > MAX_NUMBER) {
            throw new IllegalArgumentException("생성할 숫자의 개수는 1에서 9 사이여야 합니다.");
        }
    }
}
