package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    @Test
    @DisplayName("3자리 랜덤 숫자 생성 테스트")
    void generate() {
        for (int i = 0; i < 100; i++) {
            String generateString = RandomNumberGenerator.generate();
            assertThat(generateString.length()).isEqualTo(3);

            int randomNumber = Integer.parseInt(generateString);
            assertThat(randomNumber).isInstanceOf(Integer.class);
        }
    }
}