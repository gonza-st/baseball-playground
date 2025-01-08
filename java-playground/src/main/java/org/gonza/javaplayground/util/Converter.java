package org.gonza.javaplayground.util;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static List<Integer> convertStringToNumberList(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }

        Validator.validateNumeric(input);

        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
