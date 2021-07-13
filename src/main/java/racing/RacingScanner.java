package racing;

import java.io.InputStream;
import java.util.Scanner;

public class RacingScanner {
    private Scanner scanner;

    private RacingScanner(InputStream in) {
        this.scanner = new Scanner(in);
    }

    public static RacingScanner open(InputStream in) {
        return new RacingScanner(in);
    }

    public String enter() {
        return scanner.nextLine();
    }

    public void close(){
        scanner.close();
        scanner = null;
    }
}
