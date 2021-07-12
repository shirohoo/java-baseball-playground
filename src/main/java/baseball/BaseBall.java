package baseball;

class BaseBall {
    private BaseBallScanner scanner;
    private BaseBallPrinter printer;

    private int ballCount;
    private int strikeCount;

    private BaseBall() {
        this.scanner = new BaseBallScanner();
        this.printer = new BaseBallPrinter();
    }

    static BaseBall createBaseBall() {
        return new BaseBall();
    }

    void run() {
        while (strikeCount != 3) {
            computed(scanner.enter(), RandomNumberGenerator.generate());
            printer.printResult(ballCount, strikeCount);
        }
        restart();
    }

    private void restart() {
        int trigger = scanner.restartQuestion();
        if (trigger == 1) {
            createBaseBall().run();
        }
        if (trigger == 0) {
            System.out.println("게임을 종료합니다");
            System.exit(0);
        }
    }

    private void computed(String inputs, String randomNumber) {
        strikeCount = 0;
        ballCount = 0;

        for (int i = 0; i < inputs.length(); i++) {
            isBall(inputs, randomNumber, i);
            isStrike(inputs, randomNumber, i);
        }
    }

    private void isBall(String inputs, String randomNumber, int idx) {
        if (inputs.charAt(idx) != randomNumber.charAt(idx) &&
                randomNumber.contains(Character.toString(inputs.charAt(idx)))) {
            ballCount++;
        }
    }

    private void isStrike(String inputs, String randomNumber, int idx) {
        if (inputs.charAt(idx) == randomNumber.charAt(idx)) {
            strikeCount++;
        }
    }
}
