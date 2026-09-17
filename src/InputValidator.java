import static exception.ExceptionMessage.*;

public class InputValidator {

    // 입력 숫자 (타입 불일치 / 범위 초과) 검증
    public static long numDefaultValidate(String num) {
        String trimStr = inputCountCheck(num);

        // 숫자가 아닌 다른 문자가 껴있는 경우
        if (!trimStr.matches("[0-9]+")) {
            throw new IllegalArgumentException(INPUT_TYPE_NOT_MATCH);
        }

        try {
            // 범위 초과 시에 NumberFormatException 터짐
            return Long.parseLong(trimStr);
        } // 예외 번역
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_OUT_OF_RANGE);
        }
    }

    // 입력 값 개수 검증 (1개가 아닐 경우 예외)
    public static String inputCountCheck(String input) {

        // 공백만 입력
        if (input.isBlank()) {
            throw new IllegalArgumentException(INPUT_COUNT_ZERO);
        }

        // split()만 쓰면 앞의 공백이 있을 경우, 그 공백을 기준으로 나눠 ""이 0번째 원소가 되어버림
        if (input.trim().split("\\s+").length != 1) {
            throw new IllegalArgumentException(INPUT_COUNT_OVER);
        }

        return input.trim();
    }

    // 유틸리티 클래스이므로 객체 생성 방지
    private InputValidator() {}
}
