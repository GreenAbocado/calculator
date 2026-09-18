package exception;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

import static exception.ExceptionMessage.*;

public final class ExceptionHandler {   // 상속 불가
    public static void handleException(Runnable logic) {
        try {
            logic.run();
        }
        catch (IllegalArgumentException e) {
            printError("[입력 값 예외] ", e);
        } catch (ArithmeticException e) {
            printError("[계산 중 예외] ", e);
        } catch (NoSuchElementException e) {
            printError("[저장소 Empty 예외] ", e);
        } catch (RuntimeException e) {
            printError("[알 수 없는 예외] ", e);
        }
    }

    // 위 예외 처리에서 분류하여 처리할 수 있도록 예외 전환
    public static <T> T translateException(Supplier<T> logic) {
        try {
            return logic.get();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_LONG_OUT_RANGE);
        }
    }

    private static void printError(String str, Exception e) {
        System.out.println(str + e.getMessage());
    }
    // 객체 생성 방지
    private ExceptionHandler() {}
}
