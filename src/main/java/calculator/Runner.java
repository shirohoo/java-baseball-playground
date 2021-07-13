package calculator;

import java.util.Scanner;
import type.StringFactory;

class Runner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print(StringFactory.ENTER_INPUT);
            String input = sc.nextLine();
            double result = StringCalculator.create()
                    .enter(input)
                    .calculate();

            System.out.print(StringFactory.RESULT);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println(StringFactory.CALCULATOR_SET_MESSAGE);
        }
    }
}
