import calculator.ArithmeticCalculator;
import calculator.CalculateResult;
import calculator.Operator;
import io.InputValidator;
import io.MenuOption;
import java.util.List;
import java.util.Scanner;
import static exception.ExceptionHandler.handleException;
import static io.InputValidator.parseMenuOption;
import static io.OutputMessage.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator calculator = new ArithmeticCalculator();


        while (true) {
            System.out.print(MENU);

            handleException(() -> {
                MenuOption option = parseMenuOption(sc.nextLine());
                switch (option) {
                    case CALCULATE -> System.out.printf(RESULT_FORMAT, calculate(sc, calculator));
                    case FIND_ALL -> System.out.println(calculator.findAllResult());
                    case REMOVE_OLDER -> calculator.removeOlder();
                    case FIND_OVER -> System.out.println(findOverInput(sc, calculator));
                    case EXIT -> System.exit(0);
                }
            });
        }
    }

    private static Number calculate(Scanner sc, ArithmeticCalculator calculator) {
        System.out.print(INPUT_FIRST_NUM);
        Number first = InputValidator.parseNum(sc.nextLine());

        System.out.print(INPUT_SECOND_NUM);
        Number second = InputValidator.parseNum(sc.nextLine());

        System.out.print(INPUT_OPERATOR);
        Operator operator = Operator.from(InputValidator.parseChar(sc.nextLine()));

        return calculator.calculate(first, second, operator);
    }

    private static List<CalculateResult> findOverInput(Scanner sc, ArithmeticCalculator calculator) {
        System.out.print(INPUT_TARGET_NUM);
        Number num = InputValidator.parseNum(sc.nextLine());
        return calculator.findOverInput(num);
    }
}