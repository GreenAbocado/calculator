import calculator.BasicCalculator;
import calculator.Calculator;
import java.util.Scanner;

import static exception.ExceptionHandler.handleException;
import static valid.InputValidator.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new BasicCalculator();

        while (true) {
            handleException(()-> {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                long first = numDefaultValidate(sc.nextLine());

                System.out.print("두 번째 숫자를 입력하세요: ");
                long second = numDefaultValidate(sc.nextLine());

                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = inputCountCheck(sc.nextLine()).charAt(0);

                double result = calculator.calculate(first, second, operator);

                System.out.println(result % 1 == 0 ? String.valueOf((long)result) : String.valueOf(result));
            });

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (sc.nextLine().equals("exit")) {
                return;
            }
        }
    }
}