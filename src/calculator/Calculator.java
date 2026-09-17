package calculator;

import java.util.Deque;

public interface Calculator {
    // 기본 연산
    double calculate(long a, long b, char operator);

    // 연산 기록 저장 / 삭제
    void saveResult(long a, long b, char operator, double result);
    void removeFirst();
    boolean isEmpty();

    // STEP2 요구사항
    Deque<CalculateResult> getDeque();
    void setDeque(Deque<CalculateResult> deque);
}