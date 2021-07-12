package calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

enum StringCalculatorOperator {
    PLUS("+", (e1, e2) -> e1 + e2),
    MINUS("-", (e1, e2) -> e1 - e2),
    DIVISION("/", (e1, e2) -> e1 / e2),
    MULTI("*", (e1, e2) -> e1 * e2);

    private String operator;
    private BinaryOperator<Double> binaryOperator;

    StringCalculatorOperator(final String operator, final BinaryOperator<Double> binaryOperator) {
        this.operator = operator;
        this.binaryOperator = binaryOperator;
    }

    static StringCalculatorOperator from(final String operator) {
        return Arrays.stream(StringCalculatorOperator.values())
                     .filter(value -> value.operator.equals(operator))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("입력값이 올바르지 않습니다"));
    }

    Double calculate(final Double e1, final Double e2) {
        return binaryOperator.apply(e1, e2);
    }
}
