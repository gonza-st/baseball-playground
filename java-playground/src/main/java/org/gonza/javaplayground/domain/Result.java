package org.gonza.javaplayground.domain;

import java.util.List;

public interface Result {

    List<Integer> findIndices(List<Integer> answer, List<Integer> number);

    List<Result> create(int size);
}
