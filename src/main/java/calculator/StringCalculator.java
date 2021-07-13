package calculator;

import static java.lang.Double.valueOf;

import java.util.LinkedList;
import type.ArithmeticOperator;
import type.StringFactory;

class StringCalculator {
    private final LinkedList<Double> operands;
    private final LinkedList<String> operators;

    static StringCalculator create() {
        return new StringCalculator();
    }

    private StringCalculator() {
        this(new LinkedList<>(), new LinkedList<>());
    }

    private StringCalculator(LinkedList<Double> operands, LinkedList<String> operators) {
        this.operands = operands;
        this.operators = operators;
    }

    StringCalculator enter(final String s) {
        String[] values = s.split(" ");
        if (values.length < 3) {
            throw new IllegalArgumentException(StringFactory.INPUT_ERROR_MESSAGE);
        }
        for (int i = 0; i < values.length; i++) {
            validate(i, values[i]);
            add(values[i]);
        }
        return this;
    }

    private void validate(final int idx, final String value) {
        if (idx % 2 == 0 && !isNumeric(value)) {
            throw new IllegalArgumentException(StringFactory.INPUT_ERROR_MESSAGE);
        }
        if (idx % 2 == 1 && isNumeric(value)) {
            throw new IllegalArgumentException(StringFactory.INPUT_ERROR_MESSAGE);
        }
    }

    private static boolean isNumeric(final String s) {
        if ("".equals(s)) {
            return false;
        }
        return s.matches("-?\\d+(\\.\\d+)?");
    }

    private void add(final String value) {
        if (isNumeric(value)) {
            operands.add(valueOf(value));
        }
        if (!isNumeric(value)) {
            operators.add(value);
        }
    }

    double calculate() {
        double result = operands.poll();
        while (operands.size() != 0) {
            ArithmeticOperator operator = ArithmeticOperator.from(this.operators.poll());
            result = operator.operation(result, operands.poll());
        }
        return result;
    }
}
