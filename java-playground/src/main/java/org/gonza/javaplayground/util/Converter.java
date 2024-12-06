package org.gonza.javaplayground.util;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static List<Integer> convertStringToNumberList(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
