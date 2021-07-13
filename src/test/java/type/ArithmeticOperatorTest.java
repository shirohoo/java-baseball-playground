package type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ArithmeticOperatorTest {
    @ParameterizedTest
    @DisplayName("입력 테스트")
    @MethodSource("inputArgs")
    void enter(String operator, Class clazz) {
        if(!operator.contains(" ")) {
            assertThat(ArithmeticOperator.from(operator).getClass()).isEqualTo(clazz);
            return;
        }
        if(operator.contains(" ")) {
            assertThatThrownBy(() -> ArithmeticOperator.from(operator))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(StringFactory.INPUT_ERROR_MESSAGE);
        }
    }

    static Stream<Arguments> inputArgs() {
        return Stream.of(
                Arguments.of("+", ArithmeticOperator.class),
                Arguments.of("-", ArithmeticOperator.class),
                Arguments.of("/", ArithmeticOperator.class),
                Arguments.of("*", ArithmeticOperator.class),
                Arguments.of(" + ", ArithmeticOperator.class),
                Arguments.of(" - ", ArithmeticOperator.class),
                Arguments.of(" / ", ArithmeticOperator.class),
                Arguments.of(" * ", ArithmeticOperator.class));
    }

    @ParameterizedTest
    @DisplayName("입력 테스트")
    @MethodSource("calcArgs")
    void calculate(String operator, double e1, double e2, double result) {
        assertThat(ArithmeticOperator.from(operator).operation(e1, e2)).isEqualTo(result);
    }

    static Stream<Arguments> calcArgs() {
        return Stream.of(
                Arguments.of("+", 5, 3, 8),
                Arguments.of("-", 5, 3, 2),
                Arguments.of("/", 5, 2, 2.5),
                Arguments.of("*", 5, 3, 15));
    }
}

