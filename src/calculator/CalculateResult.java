package calculator;

public class CalculateResult {
    private final long firstNum;
    private final long secondNum;
    private final char operator;
    private final double result;

    private CalculateResult(long firstNum, long secondNum, char operator, double result) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.operator = operator;
        this.result = result;
    }

    public static CalculateResult of (long firstNum, long secondNum, char operator, double result) {
        return new CalculateResult(firstNum, secondNum, operator, result);
    }

    @Override
    public String toString() {
        // 자바가 문자열 연산 최적화
        return firstNum + " " + operator + " " + secondNum + " = " + result;
    }
}
