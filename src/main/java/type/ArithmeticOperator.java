package type;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum ArithmeticOperator {
    PLUS("+", (e1, e2) -> e1 + e2),
    MINUS("-", (e1, e2) -> e1 - e2),
    DIVISION("/", (e1, e2) -> e1 / e2),
    MULTI("*", (e1, e2) -> e1 * e2);

    private String operator;
    private BinaryOperator<Double> binaryOperator;

    ArithmeticOperator(final String operator, final BinaryOperator<Double> binaryOperator) {
        this.operator = operator;
        this.binaryOperator = binaryOperator;
    }

    public static ArithmeticOperator from(final String operator) {
        return Arrays.stream(ArithmeticOperator.values())
                     .filter(value -> value.operator.equals(operator))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException(Strings.INPUT_ERROR_MESSAGE));
    }

    public Double operation(final Double e1, final Double e2) {
        return binaryOperator.apply(e1, e2);
    }
}
