package org.gonza.javaplayground.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {
    public int generate() {
        Rule rule = new Rule();
        int maxSize = rule.getMaxSize();
        List<Integer> digits = getShuffledDigits();

        StringBuilder numberBuilder = new StringBuilder();
        for (int i = 0; i < maxSize; i++) {
            numberBuilder.append(digits.get(i));
        }

        return Integer.parseInt(numberBuilder.toString());
    }

    private List<Integer> getShuffledDigits() {
        List<Integer> digits = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));

        Collections.shuffle(digits);
        return digits;
    }
}
