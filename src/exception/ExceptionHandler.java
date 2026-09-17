package exception;

public class ExceptionHandler {
    public static void handleException(Runnable logic) {
        try {
            logic.run();
        }
        catch (IllegalArgumentException e) {
            System.out.println("[입력 값 예외]");
            System.out.println(e.getMessage());
        }
        catch (ArithmeticException e) {
            System.out.println("[계산 중 예외]");
            System.out.println(e.getMessage());
        }
    }

    // 객체 생성 방지
    private ExceptionHandler() {}
}
