package org.gonza.javaplayground.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

	@Test
	@DisplayName("숫자_1_9_사이인지_검증")
	void between_1_and_9() {
		assertThat(Validator.validNumber(1)).isTrue();
		assertThat(Validator.validNumber(9)).isTrue();
		assertThat(Validator.validNumber(0)).isFalse();
		assertThat(Validator.validNumber(10)).isFalse();
	}

	@Test
	@DisplayName("세자리_숫자인지_검증")
	void three_digit_number() {
		assertThat(Validator.validSize(3, Lists.newArrayList(1, 2, 3))).isTrue();
		assertThat(Validator.validSize(3, Lists.newArrayList(1, 2))).isFalse();
		assertThat(Validator.validSize(3, Lists.newArrayList(1))).isFalse();
		assertThat(Validator.validSize(3, Lists.newArrayList(1, 2, 3, 4))).isFalse();
	}

	@Test
	@DisplayName("중복_검증")
	void not_duplicate() {
		assertThat(Validator.validNotDuplicate(Lists.newArrayList(1, 2, 3, 4, 5))).isTrue();
		assertThat(Validator.validNotDuplicate(Lists.newArrayList(1, 2, 2))).isFalse();
		assertThat(Validator.validNotDuplicate(Lists.newArrayList(1))).isTrue();
	}

}