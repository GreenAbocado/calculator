package calculator;

import java.util.*;

import static exception.ExceptionMessage.*;

// 피연산자 전처리(double 캐스팅) 및 연산 수행. + 연산 결과 정수/실수 분리 및 저장소 로직 수행
public class ArithmeticCalculator {
    private final Deque<CalculateResult> deque = new ArrayDeque<>();

    public Number calculate(Number a, Number b, Operator operator) {
        // 모든 타입에 대한 연산을 수행하기 위해 가장 큰 double로 캐스팅
        double num1 = a.doubleValue();
        double num2 = b.doubleValue();

        // 연산 수행 (convertIfLong 결과 = Long or Double)
        Number result = convertIfLong(operator.operate(num1, num2));

        // a, b는 실제 입력받은 구현체로 저장 (Short, Integer, Long 등), result는 Long/Double 분리
        saveResult(a, b, operator, result);
        return result;
    }

    // Double 형식인 연산 결과가 Long에 들어갈 수 있는 정수이면 캐스팅
    private static Number convertIfLong(double result) {
        if (result % 1 == 0 && Long.MIN_VALUE <= result && result <= Long.MAX_VALUE) {
            return (long)result;
        }
        return result;
    }

    public void saveResult(Number a, Number b, Operator operator, Number result) {
        deque.add(CalculateResult.of(a, b, operator, result));
    }

    public List<CalculateResult> findAllResult() {
        validateNotEmpty();
        return new ArrayList<>(deque);
    }

    public List<CalculateResult> findOverInput(Number input) {
        validateNotEmpty();
        return deque.stream()
                .filter((result) -> result.getResult().doubleValue() > input.doubleValue())
                .toList();
    }

    public void removeOlder() {
        validateNotEmpty();
        deque.removeFirst();
    }

    public void validateNotEmpty() {
        if (deque.isEmpty()) {
            throw new NoSuchElementException(STORE_IS_EMPTY);
        }
    }
}
