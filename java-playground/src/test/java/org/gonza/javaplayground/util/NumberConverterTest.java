package org.gonza.javaplayground.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberConverterTest {
	@Test
	@DisplayName("세 자리 검증")
	void convert_size() {
		List<Integer> numbers = NumberConverter.convertBy("123");
		assertThat(numbers.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("값 변환 검증")
	void check_convert_value() {
		List<Integer> numbers = NumberConverter.convertBy("123");
		assertThat(numbers.get(0)).isEqualTo(1);
		assertThat(numbers.get(1)).isEqualTo(2);
		assertThat(numbers.get(2)).isEqualTo(3);
	}
}