package org.gonza.javaplayground.ui;

import org.gonza.javaplayground.domain.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class OutputView {
    public void printResult(List<Result> resultList) {
        if (resultList.isEmpty()) {
            System.out.println("낫싱");
            return;
        }

        Output output = new Output(resultList);

        System.out.println(output);
    }

    public void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static class Output {
        private final Map<Result, Integer> resultCountMap = new HashMap<>();

        public Output(List<Result> resultList) {
            for (Result result : resultList) {
                resultCountMap.put(result, resultCountMap.getOrDefault(result, 0) + 1);
            }
        }

        @Override
        public String toString() {
            StringBuilder resultString = new StringBuilder();

            resultCountMap.forEach((result, count) -> {
                resultString.append(count).append(result.toString()).append(" ");
            });

            return resultString.toString().trim();
        }
    }
}
