package exception;

public class ExceptionMessage {
    public static final String INPUT_INVALID_OPERATOR = "연산자를 (+, -, *, /) 중에서 선택해야 합니다.";
    public static final String INPUT_COUNT_ZERO = "입력을 하지 않았습니다.";
    public static final String INPUT_COUNT_OVER = "하나의 입력만 가능합니다.";
    public static final String INPUT_TYPE_NOT_MATCH = "숫자만 입력해야 합니다";
    public static final String INPUT_OUT_OF_RANGE = "입력 값이 범위를 초과합니다.";

    public static final String CALCULATOR_DIVIDE_ZERO = "0으로 나눌 수 없습니다.";
    public static final String CALCULATOR_OUT_OF_RANGE = "계산 중 언더/오버플로우가 발생했습니다";

    // 외부 객체 생성 방지
    private ExceptionMessage() {}
}