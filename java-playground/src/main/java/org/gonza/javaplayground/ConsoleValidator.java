package org.gonza.javaplayground;

public class ConsoleValidator implements Validator {
    @Override
    public void validate(String input) {
        validateNumeric(input);
        validateLength(input);
        validateDuplication(input);
    }

    private void validateNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요.");
        }
    }

    private void validateDuplication(String input) {
        if (input.chars().distinct().count() != 3) {
            throw new IllegalArgumentException("중복된 숫자가 있으면 안 됩니다.");
        }
    }
}
