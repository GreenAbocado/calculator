package calculator;

import java.util.*;
import static exception.ExceptionMessage.*;

public class BasicCalculator implements Calculator {

    private Deque<CalculateResult> deque = new ArrayDeque<>();

    @Override
    public double calculate(long a, long b, char operator) {

        double result = switch (operator) {
                case '+' -> Math.addExact(a, b);
                case '-' -> Math.subtractExact(a, b);
                case '*' -> Math.multiplyExact(a, b);
                case '/' -> division(a, b);
                default -> throw new IllegalArgumentException(INPUT_INVALID_OPERATOR);
            };

        saveResult(a, b, operator, result);
        return result;
    }

    // 나눗셈 예외 처리로 인한 분리
    private double division(long a, long b) {
        // 0으로 나누는 경우 예외 발생
        if (b == 0) throw new ArithmeticException(CALCULATOR_DIVIDE_ZERO);

        // 오버플로우 예외 발생 (17에는 Math.devideExact 존재 X)
        if (a == Long.MIN_VALUE && b == -1) throw new ArithmeticException(CALCULATOR_DIVIDE_OVERFLOW);

        return (double)a / b;
    }

    // STEP2 요구사항
    @Override
    public Deque<CalculateResult> getDeque() {
        if (isEmpty()) {
            throw new NoSuchElementException(STORE_IS_EMPTY);
        }
        return new ArrayDeque<>(deque);
    }

    // STEP2 요구사항
    @Override
    public void setDeque(Deque<CalculateResult> deque) {
        this.deque = deque;
    }

    @Override
    public void saveResult(long a, long b, char operator, double result) {
        deque.add(CalculateResult.of(a, b, operator, result));
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException(STORE_IS_EMPTY);
        }
        deque.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }
}
