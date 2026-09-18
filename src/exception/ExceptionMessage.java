package exception;

public final class ExceptionMessage {   // 상속 불가
    public static final String INPUT_INVALID_OPERATOR = "연산자를 (+, -, *, /) 중에서 선택해야 합니다.";
    public static final String INPUT_COUNT_ZERO = "어떤 문자/숫자도 입력하지 않았습니다.";
    public static final String INPUT_COUNT_OVER = "입력은 한 토큰만 가능합니다.";
    public static final String INPUT_NOT_NUM = "숫자만 입력해야 합니다";
    public static final String INPUT_DOUBLE_OUT_RANGE = String.format("실수 입력 범위는 %s ~ %s 입니다.", -Double.MAX_VALUE, Double.MAX_VALUE);
    public static final String INPUT_LONG_OUT_RANGE = String.format("정수 입력 범위는 %s ~ %s 입니다.", Long.MIN_VALUE, Long.MAX_VALUE);
    public static final String INPUT_INVALID_MENU_OPTION = "메뉴 옵션은 1~4와 exit만 입력할 수 있습니다";

    public static final String CALCULATOR_DIVIDE_ZERO = "0으로 나눌 수 없습니다.";
    public static final String CALCULATOR_OVERFLOW = "연산 결과가 범위를 초과했습니다";

    public static final String STORE_IS_EMPTY = "결과 저장소가 비어있습니다";

    // 외부에서 객체 생성 방지
    private ExceptionMessage() {}
}