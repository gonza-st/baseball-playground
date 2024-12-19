package org.gonza.javaplayground.util;

import java.util.ArrayList;
import java.util.List;

public class NumberConverter {
	public static List<Integer> convertBy(String string) {
		List<Integer> numbers = new ArrayList<>();
		String[] splitStrings = string.split("");

		for (String splitString : splitStrings) {
			numbers.add(Integer.parseInt(splitString));
		}

		return numbers;
	}
}
