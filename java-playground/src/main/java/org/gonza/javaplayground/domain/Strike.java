package org.gonza.javaplayground.domain;

public class Strike implements Result {

    @Override
    public boolean correct(int answer, int number) {
        return answer == number;
    }
}
