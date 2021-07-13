package racing;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingScannerTest {
//
//    @BeforeAll
//    static void setUp() {
//        scanner = RacingScanner.open();
//    }
//
//    @AfterAll
//    static void tearDown() {
//        scanner.close();
//    }

    @Test
    void enter(){
        // given
        String input = "pobi,crong,honux\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RacingScanner scanner = RacingScanner.open(System.in);

        String enter = scanner.enter();

        // when
        System.out.println(enter);
    }
}