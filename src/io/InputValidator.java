package io;

import static exception.ExceptionHandler.translateException;
import static exception.ExceptionMessage.*;

public final class InputValidator { // 상속 불가

    // 패턴 상수화

    // 입력 숫자 검증 및 getNumByType() 호출
    public static Number parseNum(String num) {
        String oneStr = defaultCheck(num);

        if (!oneStr.matches("-?[0-9]+(\\.[0-9]+)?")) {    // 숫자 형식이 아닐 경우
            throw new IllegalArgumentException(INPUT_NOT_NUM);
        }
        return getNumByType(oneStr);
    }

    // 입력 타입/범위별 래퍼 구현체 반환 (Byte, Short도 포함 : calculator의 다형성 확인 목적)
    private static Number getNumByType(String num) {
        // 실수 변환 및 오버플로우 예외
        if (num.matches("-?[0-9]+\\.[0-9]+"))  {
            double parsed = Double.parseDouble(num);
            if (Double.isInfinite(parsed)) {throw new IllegalArgumentException(INPUT_DOUBLE_OUT_RANGE);}
            return Double.parseDouble(num);
        }
        // 정수 범위별 변환, long 오버/언더플로우일 경우: (NumberFormatException -> IllegalArgumentException 전환)
        long parsed = translateException(() -> Long.parseLong(num));
        if (Byte.MIN_VALUE <= parsed && parsed <= Byte.MAX_VALUE) { return (byte)parsed; }
        if (Short.MIN_VALUE <= parsed && parsed <= Short.MAX_VALUE) { return (short)parsed; }
        if (Integer.MIN_VALUE <= parsed && parsed <= Integer.MAX_VALUE) { return (int)parsed; }
        return parsed;
    }

    // 문자 수 검증 및 반환 (입력 문자가 하나만 존재하는지 확인)
    public static char parseChar(String ch) {
        String oneStr = defaultCheck(ch);

        if (oneStr.length() != 1) { throw new IllegalArgumentException(INPUT_INVALID_OPERATOR); }
        return oneStr.charAt(0);
    }

    // 메뉴 옵션 검증
    public static MenuOption parseMenuOption(String option) {
        String oneStr = defaultCheck(option);
        return MenuOption.from(oneStr);
    }

    // 입력 값 개수 검증 (토큰이 하나만 있는지 확인)
    private static String defaultCheck(String input) {
        // 어떤 문자도 입력 안했을 경우
        if (input.isBlank()) {
            throw new IllegalArgumentException(INPUT_COUNT_ZERO);
        }
        // 2개 이상 입력했을 경우
        if (input.trim().split("\\s+").length != 1) {   // split()만 쓰면 앞의 공백이 있을 때, ""이 0번째 원소가 되어버림
            throw new IllegalArgumentException(INPUT_COUNT_OVER);
        }
        return input.trim();
    }

    // 유틸리티 클래스이므로 객체 생성 방지
    private InputValidator() {}
}
