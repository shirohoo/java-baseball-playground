package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {
    StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = StringCalculator.createStringCalculator();
    }

    @ParameterizedTest
    @DisplayName("입력 테스트")
    @ValueSource(strings = {"",
                            "++*/",
                            "12345",
                            "2 3 42",
                            "2 + + * 4 / 2",
                            "+ + + + + + /,"})
    void enter(String param) {
        assertThatThrownBy(() -> calculator.enter(param))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 올바르지 않습니다");
    }

    @ParameterizedTest
    @DisplayName("계산 테스트")
    @CsvSource(value = {"1 + 2:3",
                        "4 - 2:2",
                        "6 * 2:12",
                        "8 / 4:2",
                        "2 * 3 / 3 / 2:1",
                        "2 + 3 * 4 / 2:10"}, delimiter = ':')
    void calculate(String param, double expected) {
        calculator.enter(param);
        double result = calculator.calculate();
        assertThat(result).isEqualTo(expected);
    }
}
