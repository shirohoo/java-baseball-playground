package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.NoSuchElementException;

class OperatorsTest {
    @Test
    void 팝_예외_테스트() {
        Operators<String> operators = Operators.from(new LinkedList<>());
        Assertions.assertThatThrownBy(() -> operators.poll())
                  .isInstanceOf(NoSuchElementException.class)
                  .hasMessageContaining("queue is empty.");
    }
}
