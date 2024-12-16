package org.gonza.javaplayground.util;

import java.util.List;

public class Validator {
	private static final int MIN_NO = 0;
	private static final int MAX_NO = 10;

	public static Boolean validNumber(int number) {
		return number > MIN_NO && number < MAX_NO;
	}

	public static Boolean validSize(Integer size, List<Integer> numberList) {
		return size.equals(numberList.size());
	}

	public static Boolean validNotDuplicate(List<Integer> numberList) {
		return numberList.size() == numberList.stream().distinct().count();
	}
}
