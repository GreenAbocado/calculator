package calculator;

public class CalculateResult {
    private final Number firstNum;
    private final Number secondNum;
    private final Operator operator;
    private final Number result;

    private CalculateResult(Number firstNum, Number secondNum, Operator operator, Number result) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.operator = operator;
        this.result = result;
    }

    public static CalculateResult of (Number firstNum, Number secondNum, Operator operator, Number result) {
        return new CalculateResult(firstNum, secondNum, operator, result);
    }

    @Override
    public String toString() {
        // 각 Number 구현체의 toString() 호출로 정수/실수 다르게 출력
        return String.format("{ 피연산자1:%s, 피연산자2:%s, 연산자:%c, 결과:%s }\n",
                firstNum, secondNum, operator.getType(), result);
    }

    public Number getResult() {
        return result;
    }
}