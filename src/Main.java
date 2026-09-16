import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        long first = sc.nextLong();
        sc.nextLine();

        System.out.print("두 번째 숫자를 입력하세요: ");
        long second = sc.nextLong();
        sc.nextLine();

        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = sc.nextLine().charAt(0);

        double result = operate(first, second, operator);

        if (result % 1 == 0) {
            System.out.println("결과 : " + (long) result);
        } else {
            System.out.println("결과 : " + result);
        }
    }

    private static double operate(long a, long b, char operator) {
        return switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> (double)a / b;
            default -> 0;
        };
    }
}