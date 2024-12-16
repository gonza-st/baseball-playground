package org.gonza.javaplayground.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
	@Test
	void size() {
		List<Integer> randomNumbers = RandomNumberGenerator.generate(3, 1, 9);
		assertThat(randomNumbers.size()).isEqualTo(3);
	}

	@Test
	void range() {
		List<Integer> randomNumbers = RandomNumberGenerator.generate(3, 1, 9);
		randomNumbers.forEach(number -> {
			assertThat(number).isGreaterThan(0);
			assertThat(number).isLessThan(10);
		});
	}
}