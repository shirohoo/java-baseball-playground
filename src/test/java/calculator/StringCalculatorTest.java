package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import type.StringFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {
    StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = StringCalculator.create();
    }

    @ParameterizedTest
    @ValueSource(strings = {"",
                            "++*/",
                            "12345",
                            "2 3 42",
                            "2 + + * 4 / 2",
                            "+ + + + + + /,"})
    void 입력_테스트(String param) {
        assertThatThrownBy(() -> calculator.enter(param))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(StringFactory.INPUT_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3",
                        "4 - 2:2",
                        "6 * 2:12",
                        "8 / 4:2",
                        "2 * 3 / 3 / 2:1",
                        "2 + 3 * 4 / 2:10"}, delimiter = ':')
    void 계산_테스트(String param, double expected) {
        calculator.enter(param);
        double result = calculator.calculate();
        assertThat(result).isEqualTo(expected);
    }
}
