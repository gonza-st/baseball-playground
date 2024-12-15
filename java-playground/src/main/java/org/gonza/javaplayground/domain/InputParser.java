package org.gonza.javaplayground.domain;

import java.util.List;

public class InputParser {
    public List<Integer> parseToList(int number) {
        return String.valueOf(number)
                .chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();
    }

    public List<Integer> parseToList(String input) {
        return input
                .chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .boxed()
                .toList();
    }
}
