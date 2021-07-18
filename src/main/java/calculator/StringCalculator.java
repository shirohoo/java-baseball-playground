package calculator;

import type.ArithmeticOperator;
import type.StringFactory;

import java.util.LinkedList;

class StringCalculator {
    private final Operators<Double> operands;
    private final Operators<String> operators;

    static StringCalculator create() {
        return new StringCalculator();
    }

    private StringCalculator() {
        this(Operators.from(new LinkedList<>()),
             Operators.from(new LinkedList<>()));
    }

    private StringCalculator(Operators<Double> operands, Operators<String> operators) {
        this.operands = operands;
        this.operators = operators;
    }

    StringCalculator enter(final String s) {
        String[] values = s.split(" ");
        if(values.length < 3) {
            throw new IllegalArgumentException(StringFactory.INPUT_ERROR_MESSAGE);
        }
        for(int i = 0; i < values.length; i++) {
            validate(i, values[i]);
            putIntoStack(values[i]);
        }
        return this;
    }

    private void validate(final int index, final String value) {
        if(isEvenNumber(index) && !isNumeric(value)) {
            throw new IllegalArgumentException(StringFactory.INPUT_ERROR_MESSAGE);
        }
        if(!isEvenNumber(index) && isNumeric(value)) {
            throw new IllegalArgumentException(StringFactory.INPUT_ERROR_MESSAGE);
        }
    }

    private boolean isEvenNumber(final int index) {
        return index % 2 == 0;
    }

    private boolean isNumeric(final String value) {
        return value.matches("[0-9]");
    }

    private void putIntoStack(final String value) {
        if(isNumeric(value)) {
            Double number = Double.valueOf(value);
            this.operands.add(number);
        }
        if(!isNumeric(value)) {
            this.operators.add(value);
        }
    }

    double calculate() {
        double result = this.operands.poll();
        while(this.operands.size() != 0) {
            ArithmeticOperator operator = ArithmeticOperator.from(this.operators.poll());
            result = operator.operation(result, this.operands.poll());
        }
        return result;
    }
}
