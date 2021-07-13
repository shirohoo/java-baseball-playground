package type;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ArithmeticOperatorTest {
    @ParameterizedTest
    @DisplayName("정상 입력 테스트")
    @MethodSource("normalInputArgs")
    void normalInput(String operator, Class clazz) {
        assertThat(ArithmeticOperator.from(operator).getClass()).isEqualTo(clazz);
    }

    static Stream<Arguments> normalInputArgs() {
        return Stream.of(
                Arguments.of("+", ArithmeticOperator.class),
                Arguments.of("-", ArithmeticOperator.class),
                Arguments.of("/", ArithmeticOperator.class),
                Arguments.of("*", ArithmeticOperator.class));
    }

    @ParameterizedTest
    @DisplayName("비정상 입력 테스트")
    @MethodSource("abnormalInputArgs")
    void abnormalInput(String operator, Class clazz) {
        assertThatThrownBy(() -> ArithmeticOperator.from(operator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(StringFactory.INPUT_ERROR_MESSAGE);
    }

    static Stream<Arguments> abnormalInputArgs() {
        return Stream.of(
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

