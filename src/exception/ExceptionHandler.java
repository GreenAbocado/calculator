package exception;

import java.util.NoSuchElementException;

public class ExceptionHandler {
    public static void handleException(Runnable logic) {
        try {
            logic.run();
        }
        catch (IllegalArgumentException e) {
            printError("[입력 값 예외]: ", e);
        } catch (ArithmeticException e) {
            printError("[계산 중 예외]: ", e);
        } catch (NoSuchElementException e) {
            printError("[저장소 관련 예외]: ", e);
        }
    }

    private static void printError(String str, Exception e) {
        System.out.println(
                "===============================\n" +
                        str + e.getMessage() + "\n" +
                "==============================="
        );
    }

    // 객체 생성 방지
    private ExceptionHandler() {}
}
