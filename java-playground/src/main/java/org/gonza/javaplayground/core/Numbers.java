package org.gonza.javaplayground.core;

import org.gonza.javaplayground.util.Validator;

import java.util.List;

public record Numbers(List<Integer> values) {
    public Numbers {
        Validator.validateListSize(values.size());
        values = List.copyOf(values);
    }
}
