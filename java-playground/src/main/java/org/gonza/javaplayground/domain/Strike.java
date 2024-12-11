package org.gonza.javaplayground.domain;

import java.util.List;

public class Strike implements Result {

    private int count;

    @Override
    public int judge(int answer, int[] numberList) {
        return 1;
    }
}
