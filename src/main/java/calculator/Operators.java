package calculator;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Operators<T> {
    private final LinkedList<T> operators;

    private Operators(LinkedList<T> operands) {
        this.operators = operands;
    }

    static <T> Operators<T> from(LinkedList<T> operands) {
        return new Operators<T>(operands);
    }

    int size() {
        return operators.size();
    }

    boolean add(T element) {
        return operators.add(element);
    }

    T poll() {
        if(operators.size() <= 0) {
            throw new NoSuchElementException("queue is empty.");
        }
        return operators.poll();
    }
}
