package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

import static exception.ExceptionMessage.*;

// 연산자 상수 및 연산 로직 보관
public enum Operator {
    PLUS('+', (a, b) -> a+b),
    MINUS('-', (a, b) -> a-b),
    MULTIPLY('*', (a, b) -> a*b),
    DIVISION('/', (a, b) -> {
        if (b == 0) {throw new ArithmeticException(CALCULATOR_DIVIDE_ZERO);} return a/b; // 0으로 나눌 시 예외
    });

    private final char type;
    private final BiFunction<Double, Double, Double> operationLogic;

    Operator(char type, BiFunction<Double, Double, Double> operationLogic) {
        this.type = type;
        this.operationLogic = operationLogic;
    }

    // 문자를 통해 해당 연산자 반환 (상수만 추가하면 메서드 변경 없이 사용 가능)
    public static Operator from (char type) {
        return Arrays.stream(Operator.values())
                .filter((operator) -> operator.type == type)
                .findFirst().orElseThrow(() -> new IllegalArgumentException(INPUT_INVALID_OPERATOR));
    }

    // 연산 수행 (연산 결과가 오버플로우일 경우 예외)
    public double operate(double a, double b) {
        double result = operationLogic.apply(a, b);
        if (Double.isInfinite(result)) {
            throw new ArithmeticException(CALCULATOR_OVERFLOW);
        }
        return result;
    }

    public char getType() {
        return type;
    }
}