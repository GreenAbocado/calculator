import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        handleException(()-> {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            long first = sc.nextLong();

            System.out.print("두 번째 숫자를 입력하세요: ");
            long second = sc.nextLong();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            double result = operate(first, second, operator);

            if (result % 1 == 0) {
                System.out.println("결과 : " + (long) result);
            } else {
                System.out.println("결과 : " + result);
            }
        }, sc);
    }

    private static double operate(long a, long b, char operator) {
        // 오버/언더 플로우 예외 발생
        return switch (operator) {
            case '+' -> Math.addExact(a, b);
            case '-' -> Math.subtractExact(a, b);
            case '*' -> Math.multiplyExact(a, b);
            case '/' -> division(a, b);
            default -> throw new IllegalArgumentException("잘못된 연산자를 입력했습니다.");
        };
    }

    // 나눗셈 예외 처리로 인한 분리
    private static double division(long a, long b) {
        // 0으로 나누는 경우 예외 발생
        if (b == 0) throw new IllegalArgumentException("0으로 나눌 수 없습니다.");

        // 오버플로우 예외 발생 (17에는 Math.devideExact 존재 X)
        if (a == Long.MIN_VALUE && b == -1) throw new ArithmeticException();

        return (double)a / b;
    }

    private static void handleException(Runnable logic, Scanner sc) {
        try {
            logic.run();
        } catch (InputMismatchException e) {    // scanner 관련 예외 : 피연산자 타입 및 범위 체크
            System.out.println("피연산자가 올바르지 않습니다.");
            sc.nextLine();  // 예외 시 버퍼에 남아있는 데이터 제거
        } catch (ArithmeticException e) {
            System.out.println("연산 중 오버/언더플로우 발생");
        } catch (IllegalArgumentException e) {  // 그 외 입력 예외 커스텀 예외 대신 메시지 출력
            System.out.println(e.getMessage());
        }
    }
}