package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorOperatorTest {
    @ParameterizedTest
    @DisplayName("입력 테스트")
    @MethodSource("inputArgs")
    void enter(String operator, Class clazz) {
        if(!operator.contains(" ")) {
            assertThat(StringCalculatorOperator.from(operator).getClass()).isEqualTo(clazz);
            return;
        }
        if(operator.contains(" ")) {
            assertThatThrownBy(() -> StringCalculatorOperator.from(operator))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력값이 올바르지 않습니다");
        }
    }

    static Stream<Arguments> inputArgs() {
        return Stream.of(
                Arguments.of("+", StringCalculatorOperator.class),
                Arguments.of("-", StringCalculatorOperator.class),
                Arguments.of("/", StringCalculatorOperator.class),
                Arguments.of("*", StringCalculatorOperator.class),
                Arguments.of(" + ", StringCalculatorOperator.class),
                Arguments.of(" - ", StringCalculatorOperator.class),
                Arguments.of(" / ", StringCalculatorOperator.class),
                Arguments.of(" * ", StringCalculatorOperator.class));
    }

    @ParameterizedTest
    @DisplayName("입력 테스트")
    @MethodSource("calcArgs")
    void calculate(String operator, double e1, double e2, double result) {
        assertThat(StringCalculatorOperator.from(operator).calculate(e1, e2)).isEqualTo(result);
    }

    static Stream<Arguments> calcArgs() {
        return Stream.of(
                Arguments.of("+", 5, 3, 8),
                Arguments.of("-", 5, 3, 2),
                Arguments.of("/", 5, 2, 2.5),
                Arguments.of("*", 5, 3, 15));
    }
}

