package baseball;

class BaseBallPrinter {
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String COMPLETE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    void printResult(final int ballCount, final int strikeCount) {
        if (ballCount != 0) {
            System.out.print(ballCount + BALL);
        }
        if (strikeCount != 0) {
            System.out.print(strikeCount + STRIKE);
        }
        if (strikeCount == 0 && ballCount == 0) {
            System.out.print(NOTHING);
        }
        if (strikeCount == 3) {
            System.out.println(COMPLETE);
        }
    }
}
