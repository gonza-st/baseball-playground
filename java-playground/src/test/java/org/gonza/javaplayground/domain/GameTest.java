package org.gonza.javaplayground.domain;

import org.gonza.javaplayground.exception.NotNumberIncludedException;
import org.gonza.javaplayground.ui.View;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class GameTest {

    private Game game;
    private NumberGenerator numberGenerator;
    private InputParser inputParser;
    private View view;
    private Rule rule;
    private Referee referee;

    @BeforeEach
    void setUp() {
        numberGenerator = mock(NumberGenerator.class);
        inputParser = mock(InputParser.class);
        rule = mock(Rule.class);
        referee = mock(Referee.class);
        view = mock(View.class);

        game = new Game(numberGenerator, inputParser, view, rule, referee);
    }

    @Test
    void 게임이_모두_스트라이크라면_게임이_종료된다() {
        when(numberGenerator.generate()).thenReturn(123);
        when(inputParser.parseToList(123)).thenReturn(List.of(1,2,3));
        when(view.requestInput()).thenReturn("123");
        when(referee.isAllStrike(any())).thenReturn(true);

        game.start();

        verify(view).gameEnd();
    }

    @Test
    void 게임이_모두_스트라이크가_아니라면_다시_입력을_요청한다() {
        String first = "456";
        String second = "789";
        String third = "123";
        when(numberGenerator.generate()).thenReturn(123);
        when(inputParser.parseToList(123)).thenReturn(List.of(1, 2, 3));
        when(view.requestInput())
                .thenReturn(first)
                .thenReturn(second)
                .thenReturn(third);
        when(inputParser.parseToList(first)).thenReturn(List.of(4, 5, 6));
        when(inputParser.parseToList(second)).thenReturn(List.of(7, 8, 9));
        when(inputParser.parseToList(third)).thenReturn(List.of(1, 2, 3));
        when(referee.isAllStrike(any()))
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(true);

        game.start();

        verify(view, times(3)).requestInput();
        verify(view, times(2)).printResult(any());
        verify(view).gameEnd();
    }

    @Test
    void 잘못된_입력을_하면_다시_입력을_요청한다() {
        String firstInput = "12a";
        String secondInput = "123";
        String errorMessage = "입력한 값에 숫자가 포함되어있지 않습니다";
        when(view.requestInput()).thenReturn(firstInput, secondInput);
        doThrow(new NotNumberIncludedException(errorMessage))
                .when(rule).validateNumber(firstInput);
        doNothing()
                .when(rule).validateNumber(secondInput);
        when(inputParser.parseToList(secondInput)).thenReturn(List.of(1,2,3));
        when(referee.isAllStrike(any())).thenReturn(true);

        game.start();

        verify(view, times(1)).printErrorMessage(errorMessage);
        verify(view, times(2)).requestInput();
    }

    @Test
    void 게임이_종료된_이후_다시_게임을_재시작하면_다시_입력을_요청한다() {
        String first = "123";
        String second = "789";
        String third = "456";
        when(numberGenerator.generate())
                .thenReturn(123)
                .thenReturn(456);
        when(inputParser.parseToList(123)).thenReturn(List.of(1, 2, 3));
        when(inputParser.parseToList(456)).thenReturn(List.of(4, 5, 6));

        when(view.requestInput())
                .thenReturn(first)
                .thenReturn(second)
                .thenReturn(third);

        when(inputParser.parseToList(first)).thenReturn(List.of(1, 2, 3));
        when(inputParser.parseToList(second)).thenReturn(List.of(7, 8, 9));
        when(inputParser.parseToList(third)).thenReturn(List.of(4, 5, 6));

        when(referee.isAllStrike(any()))
                .thenReturn(true)  // 첫 번째 입력: 모두 스트라이크
                .thenReturn(false) // 두 번째 입력: 정답 아님
                .thenReturn(true); // 세 번째 입력: 모두 스트라이크

        when(view.restartOrExit())
                .thenReturn("1")
                .thenReturn("2");

        when(rule.isRestart(any()))
                .thenReturn(true)
                .thenReturn(false);

        game.start();

        verify(view, times(3)).requestInput();
        verify(view, times(2)).restartOrExit();
        verify(view, times(2)).gameEnd();
    }
}
