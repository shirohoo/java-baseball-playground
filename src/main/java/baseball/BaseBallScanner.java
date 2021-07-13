package baseball;

import java.util.Scanner;
import type.Strings;

class BaseBallScanner {
    private final Scanner scanner = new Scanner(System.in);
    private static final String ENTER_NUMBER = "\n숫자를 입력해 주세요 : ";
    private static final String CORRECT_ENTER_NUMBER = "\n숫자를 제대로 입력해 주세요 : ";

    String enter() {
        System.out.print(ENTER_NUMBER);
        String input = scanner.nextLine();
        while (input.length() != 3) {
            System.out.print(CORRECT_ENTER_NUMBER);
            input = scanner.nextLine();
        }
        return input;
    }

    int restartQuestion() {
        System.out.println(Strings.RESTART_QUESTION);
        int input = scanner.nextInt();
        while (input != 1 && input != 2) {
            System.out.println(Strings.INPUT_ERROR_MESSAGE);
            System.out.println(Strings.RESTART_QUESTION);
            input = scanner.nextInt();
        }
        scanner.nextLine();
        return input;
    }
}
