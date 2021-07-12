package calculator;

import java.util.LinkedList;

import static java.lang.Double.valueOf;

class StringCalculator {
    private String[] values;
    private LinkedList<Double> operands;
    private LinkedList<String> operators;

    private double result;

    private StringCalculator() {
        this(new LinkedList<>(), new LinkedList<>());
    }

    static StringCalculator createStringCalculator() {
        return new StringCalculator();
    }

    private StringCalculator(LinkedList<Double> operands, LinkedList<String> operators) {
        this.operands = operands;
        this.operators = operators;
    }

    StringCalculator enter(final String s) {
        values = s.split(" ");
        if(values.length < 3) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다");
        }
        for(int i = 0; i < values.length; i++) {
            validate(i, values[i]);
            add(values[i]);
        }
        return this;
    }

    private void validate(final int idx, final String value) {
        if(idx % 2 == 0 && !isNumeric(value)) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다");
        }
        if(idx % 2 == 1 && isNumeric(value)) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다");
        }
    }

    private static boolean isNumeric(final String s) {
        if("".equals(s)) {
            return false;
        }
        return s.matches("-?\\d+(\\.\\d+)?");
    }

    private void add(final String value) {
        if(isNumeric(value)) {
            operands.add(valueOf(value));
        }
        if(!isNumeric(value)) {
            operators.add(value);
        }
    }

    double calculate() {
        result = operands.poll();
        while(operands.size() != 0) {
            StringCalculatorOperator stringCalculatorOperator = StringCalculatorOperator.from(operators.poll());
            result = stringCalculatorOperator.calculate(result, operands.poll());
        }
        return result;
    }
}
