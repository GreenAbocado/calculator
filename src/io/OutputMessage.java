package io;

public final class OutputMessage {  // 상속 불가
    public static final String MENU = """
    =========================================
    메뉴 번호를 입력하세요 (exit 입력시 종료) :
    1. 연산
    2. 연산 결과 조회
    3. 가장 오래된 결과 삭제
    4. 입력 값보다 큰 결과 출력
    ==========================================
    """;
    public static final String INPUT_FIRST_NUM = "첫 번째 숫자를 입력하세요: ";
    public static final String INPUT_SECOND_NUM = "두 번째 숫자를 입력하세요: ";
    public static final String INPUT_OPERATOR = "연산자를 입력하세요: ";
    public static final String INPUT_TARGET_NUM = "기준 값을 입력하세요: ";
    public static final String RESULT_FORMAT = "결과: %s\n";

    private OutputMessage() {}
}