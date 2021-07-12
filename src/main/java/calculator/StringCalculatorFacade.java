package calculator;

import java.util.Scanner;

class StringCalculatorFacade {
    static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine();

            double result = StringCalculator.createStringCalculator()
                                            .enter(input).calculate();

            System.out.println("result = " + result);
        }
    }
}
