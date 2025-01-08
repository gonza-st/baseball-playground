package org.gonza.javaplayground.util;

import org.gonza.javaplayground.core.RuleConstants;

public class Validator {
    public static void validateListSize(int size) {
        if (size < RuleConstants.MIN_NUMBER || size > RuleConstants.MAX_NUMBER) {
            throw new IllegalArgumentException("생성할 숫자의 개수는 1에서 9 사이여야 합니다.");
        }
    }

    public static void validateNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    public static void validateLength(String input) {
        if (input.length() != RuleConstants.REQUIRED_LENGTH) {
            throw new IllegalArgumentException(
                    RuleConstants.REQUIRED_LENGTH + "개의 숫자를 입력해주세요.");
        }
    }

    public static void validateDuplication(String input) {
        if (input.chars().distinct().count() != RuleConstants.REQUIRED_LENGTH) {
            throw new IllegalArgumentException("중복된 숫자가 있으면 안 됩니다.");
        }
    }
}
