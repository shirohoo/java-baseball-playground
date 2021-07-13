package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacerTest {
    Racer racer;

    @BeforeEach
    void setUp() {
        racer = Racer.of("racer", 3);
    }

    @Test
    void getName() {
        assertThat(racer.getName()).isEqualTo("racer");
    }

    @Test
    void getPosition() {
        assertThat(racer.getPosition()).isEqualTo(3);
    }
}