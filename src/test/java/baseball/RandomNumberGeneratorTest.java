package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    @Test
    void generate() {
        for (int i = 0; i < 100; i++) {
            String generateString = RandomNumberGenerator.generate();
            assertThat(generateString.length()).isEqualTo(3);

            int randomNumber = Integer.parseInt(generateString);
            assertThat(randomNumber).isInstanceOf(Integer.class);
        }
    }
}