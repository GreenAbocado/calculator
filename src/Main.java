import java.util.Scanner;

import static exception.ExceptionHandler.handleException;
import static exception.ExceptionMessage.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            handleException(()-> {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                long first = InputValidator.numDefaultValidate(sc.nextLine());

                System.out.print("두 번째 숫자를 입력하세요: ");
                long second = InputValidator.numDefaultValidate(sc.nextLine());

                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = InputValidator.inputCountCheck(sc.nextLine()).charAt(0);

                double result = operate(first, second, operator);

                if (result % 1 == 0) {
                    System.out.println("결과 : " + (long) result);
                } else {
                    System.out.println("결과 : " + result);
                }
            });

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (sc.nextLine().equals("exit")) return;
        }
    }

    // 이후 STEP3에서 리팩토링
    private static double operate(long a, long b, char operator) {

        try {
            return switch (operator) {
                case '+' -> Math.addExact(a, b);
                case '-' -> Math.subtractExact(a, b);
                case '*' -> Math.multiplyExact(a, b);
                case '/' -> division(a, b);
                default -> throw new IllegalArgumentException(INPUT_INVALID_OPERATOR);
            };
        }   // Math 오버플로우 예외 번역
        catch (ArithmeticException e) {
            if (e.getMessage().equals(CALCULATOR_DIVIDE_ZERO)) {
                throw e;
            }
            throw new ArithmeticException(CALCULATOR_OUT_OF_RANGE);
        }
    }

    // 나눗셈 예외 처리로 인한 분리
    private static double division(long a, long b) {
        // 0으로 나누는 경우 예외 발생
        if (b == 0) throw new ArithmeticException(CALCULATOR_DIVIDE_ZERO);

        // 오버플로우 예외 발생 (17에는 Math.devideExact 존재 X)
        if (a == Long.MIN_VALUE && b == -1) throw new ArithmeticException();

        return (double)a / b;
    }
}