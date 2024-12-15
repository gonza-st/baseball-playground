package org.gonza.javaplayground.exception;

public class ExceedsMaxLengthException extends RuntimeException {
    public ExceedsMaxLengthException(String message) {
        super(message);
    }
}
