package racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacersTest {
    Racers racers;

    @BeforeEach
    void setUp() {
        racers = new Racers(List.of(
                Racer.of("pobi", 5),
                Racer.of("crong", 4),
                Racer.of("honux", 5)
        ));
    }

    @Test
    void size() {
        assertThat(racers.size()).isEqualTo(3);
    }

    @Test
    void getRacer() {
        assertThat(racers.getRacer(1)).isNotNull();
        assertThat(racers.getRacer(1).getName()).isEqualTo("crong");
        assertThat(racers.getRacer(1).getPosition()).isEqualTo(4);
    }

    @Test
    void iterator() {
        assertThat(racers.iterator()).isInstanceOf(Iterator.class);
    }
}