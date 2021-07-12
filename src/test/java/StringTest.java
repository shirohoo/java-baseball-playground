import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {
    @DisplayName("샘플코드")
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @DisplayName("요구사항1-1")
    @Test
    void split_1() {
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @DisplayName("요구사항1-2")
    @Test
    void split_2() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @DisplayName("요구사항2")
    @Test
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("요구사항3-1")
    @Test
    void charAt_1() {
        char actual = "abc".charAt(1);
        assertThat(actual).isEqualTo('b');
    }

    @DisplayName("요구사항3-2")
    @Test
    void charAt_2() {
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range:");
    }
}
