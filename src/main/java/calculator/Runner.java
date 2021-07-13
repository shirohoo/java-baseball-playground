package calculator;

import java.util.Scanner;
import type.Strings;

class Runner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print(Strings.ENTER_INPUT);
            String input = sc.nextLine();
            double result = StringCalculator.create()
                    .enter(input)
                    .calculate();

            System.out.print(Strings.RESULT);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println(Strings.CALCULATOR_SET_MESSAGE);
        }
    }
}
