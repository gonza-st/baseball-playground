package org.gonza.javaplayground;

import org.gonza.javaplayground.core.Game;
import org.gonza.javaplayground.core.Judgement;
import org.gonza.javaplayground.core.NumberGenerator;
import org.gonza.javaplayground.core.RuleConstants;
import org.gonza.javaplayground.view.Printer;
import org.gonza.javaplayground.view.Reader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GameTest {
    @Mock
    private NumberGenerator numberGenerator;
    @Mock
    private Reader reader;
    @Mock
    private Judgement judgement;

    @Mock
    private Printer printer;

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(numberGenerator, reader, judgement, printer);
    }

    @Test
    @DisplayName("게임이 정상적으로 종료된다")
    void playGameUntilWinAndQuit() {
        // given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        given(numberGenerator.generatorRandomNumber(RuleConstants.REQUIRED_LENGTH))
                .willReturn(computerNumbers);

        given(reader.read())
                .willReturn("123");

        given(reader.readWithoutValidation())
                .willReturn("2");

        given(judgement.compareNumber(any(), any()))
                .willReturn("3스트라이크");

        // when
        game.play();

        // then
        verify(numberGenerator).generatorRandomNumber(RuleConstants.REQUIRED_LENGTH);
        verify(reader, times(1)).read();
        verify(reader, times(1)).readWithoutValidation();
        verify(judgement).compareNumber(eq(computerNumbers), anyList());
    }

    @Test
    @DisplayName("게임에서 여러 번 시도 후 승리하고 종료된다")
    void playMultipleTriesUntilWinAndQuit() {
        // given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        given(numberGenerator.generatorRandomNumber(RuleConstants.REQUIRED_LENGTH))
                .willReturn(computerNumbers);

        given(reader.read())
                .willReturn("456")    // 첫 번째 시도 (아웃)
                .willReturn("147")    // 두 번째 시도 (1볼)
                .willReturn("123");    // 세 번째 시도 (승리)


        given(judgement.compareNumber(any(), any()))
                .willReturn("아웃")
                .willReturn("1볼")
                .willReturn("3스트라이크");

        given(reader.readWithoutValidation())
                .willReturn("2");

        // when
        game.play();

        // then
        verify(numberGenerator).generatorRandomNumber(RuleConstants.REQUIRED_LENGTH);
        verify(reader, times(3)).read();
        verify(reader, times(1)).readWithoutValidation();
        verify(judgement, times(3)).compareNumber(eq(computerNumbers), anyList());
    }

    @Test
    @DisplayName("게임에서 승리 후 새 게임을 시작하고 종료한다")
    void playGameWinStartNewGameAndQuit() {
        // given
        List<Integer> firstGameNumbers = Arrays.asList(1, 2, 3);
        List<Integer> secondGameNumbers = Arrays.asList(4, 5, 6);

        given(numberGenerator.generatorRandomNumber(RuleConstants.REQUIRED_LENGTH))
                .willReturn(firstGameNumbers)
                .willReturn(secondGameNumbers);

        given(reader.read())
                .willReturn("123")    // 첫 게임 승리
                .willReturn("456");   // 두 번째 게임 승리

        given(reader.readWithoutValidation())
                .willReturn("1")      // 새 게임 시작 선택
                .willReturn("2");     // 종료 선택

        given(judgement.compareNumber(any(), any()))
                .willReturn("3스트라이크")
                .willReturn("3스트라이크");

        // when
        game.play();

        // then
        verify(numberGenerator, times(2)).generatorRandomNumber(RuleConstants.REQUIRED_LENGTH);
        verify(reader, times(2)).read();
        verify(reader, times(2)).readWithoutValidation();
        verify(judgement, times(2)).compareNumber(anyList(), anyList());
    }


    @Test
    @DisplayName("잘못된 입력 처리 후 게임이 계속된다")
    void handleInvalidInputAndContinue() {
        // given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        given(numberGenerator.generatorRandomNumber(RuleConstants.REQUIRED_LENGTH))
                .willReturn(computerNumbers);

        given(reader.read())
                .willThrow(new IllegalArgumentException("잘못된 입력"))  // 첫 번째 입력 (예외)
                .willReturn("123");   // 두 번째 입력 (정답)

        given(reader.readWithoutValidation())
                .willReturn("2");     // 종료 선택

        given(judgement.compareNumber(any(), any()))
                .willReturn("3스트라이크");

        // when
        game.play();

        // then
        verify(numberGenerator).generatorRandomNumber(RuleConstants.REQUIRED_LENGTH);
        verify(reader, times(2)).read();
        verify(reader, times(1)).readWithoutValidation();
        verify(judgement).compareNumber(eq(computerNumbers), anyList());
    }

}
