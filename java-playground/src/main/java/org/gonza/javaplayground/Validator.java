package org.gonza.javaplayground;

public class Validator {
    public void validate(String input) {
        validateNumeric(input);
        validateLength(input);
        validateDuplication(input);
    }

    public void validate(int size) {
        validateListSize(size);
    }

    private static void validateListSize(int size) {
        if (size < RuleConstants.MIN_NUMBER || size > RuleConstants.MAX_NUMBER) {
            throw new IllegalArgumentException("생성할 숫자의 개수는 1에서 9 사이여야 합니다.");
        }
    }

    private void validateNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private void validateLength(String input) {
        if (input.length() != RuleConstants.REQUIRED_LENGTH) {
            throw new IllegalArgumentException(
                    RuleConstants.REQUIRED_LENGTH + "개의 숫자를 입력해주세요.");
        }
    }

    private void validateDuplication(String input) {
        if (input.chars().distinct().count() != RuleConstants.REQUIRED_LENGTH) {
            throw new IllegalArgumentException("중복된 숫자가 있으면 안 됩니다.");
        }
    }
}
