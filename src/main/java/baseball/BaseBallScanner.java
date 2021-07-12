package baseball;

class BaseBallScanner {
    private static final java.util.Scanner scanner = new java.util.Scanner(System.in);

    String enter() {
        System.out.print("\n숫자를 입력해 주세요 : ");
        String input = scanner.nextLine();
        while (input.length() != 3) {
            System.out.print("\n숫자를 제대로 입력해 주세요 : ");
            input = scanner.nextLine();
        }
        return input;
    }

    int restartQuestion() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        int input = scanner.nextInt();
        while (input != 1 && input != 2) {
            System.out.println("입력이 올바르지 않습니다.");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            input = scanner.nextInt();
        }
        scanner.nextLine();
        return input;
    }
}
