package org.gonza.javaplayground.domain;

import org.gonza.javaplayground.exception.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RuleValidatorTest {

    @Test
    void 입력한_값과_정답의_자릿수가_다르면_예외가_발생합니다() {
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> number = List.of(1, 2);
        Rule rule = new Rule();
        RuleValidator ruleValidator = new RuleValidator(rule);

        assertThatThrownBy(() -> ruleValidator.validateEqualLengths(answer, number))
                .isInstanceOf(InvalidLengthException.class)
                .hasMessage("입력값과 정답의 자릿수가 일치하지 않습니다");
    }

    @Test
    void 입력한_값과_규칙의_자릿수가_다르면_예외가_발생합니다() {
        List<Integer> number = List.of(1, 2);
        int maxSize = 3;
        Rule rule = new Rule(maxSize);
        RuleValidator ruleValidator = new RuleValidator(rule);

        assertThatThrownBy(() -> ruleValidator.validateRequiredSize(number))
                .isInstanceOf(InvalidNumberLengthException.class)
                .hasMessage("입력한 값이 3자리수가 아닙니다.");
    }

    @Test
    void 입력한_값_중에_같은_값이_포함되면_예외가_발생합니다() {
        List<Integer> number = List.of(1, 2, 2);
        Rule rule = new Rule();
        RuleValidator ruleValidator = new RuleValidator(rule);

        assertThatThrownBy(() -> ruleValidator.validateDuplicateValue(number))
                .isInstanceOf(DuplicateValueException.class)
                .hasMessage("입력한 값 중 같은 값이 포함되어 있습니다");
    }

    @Test
    void 입력한_값_중에_숫자가_포함되어있지_않다면_예외가_발생합니다() {
        String input1 = "12lmk";
        String input2 = "12 ";
        String input3 = "12`";
        String input4 = "12+=";
        Rule rule = new Rule();
        RuleValidator ruleValidator = new RuleValidator(rule);

        assertThatThrownBy(() -> ruleValidator.validateNumericInput(input1))
                .isInstanceOf(NotNumberIncludedException.class)
                .hasMessage("입력한 값에 숫자가 포함되어있지 않습니다");

        assertThatThrownBy(() -> ruleValidator.validateNumericInput(input2))
                .isInstanceOf(NotNumberIncludedException.class)
                .hasMessage("입력한 값에 숫자가 포함되어있지 않습니다");

        assertThatThrownBy(() -> ruleValidator.validateNumericInput(input3))
                .isInstanceOf(NotNumberIncludedException.class)
                .hasMessage("입력한 값에 숫자가 포함되어있지 않습니다");

        assertThatThrownBy(() -> ruleValidator.validateNumericInput(input4))
                .isInstanceOf(NotNumberIncludedException.class)
                .hasMessage("입력한 값에 숫자가 포함되어있지 않습니다");
    }

    @Test
    void 재시작_혹은_게임종료_플래그가_아닌경우_예외가_발생한다() {
        String anyFlag = "9";
        Rule rule = new Rule();
        RuleValidator ruleValidator = new RuleValidator(rule);

        assertThatThrownBy(() -> ruleValidator.validateRestartOrExitFlag(anyFlag))
                .isInstanceOf(InvalidRestartOrExitFlagException.class)
                .hasMessage("1 혹은 2 중에 입력해주세요");
    }
}
