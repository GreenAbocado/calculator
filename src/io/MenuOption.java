package io;

import java.util.Arrays;

import static exception.ExceptionMessage.INPUT_INVALID_MENU_OPTION;

public enum MenuOption {
    CALCULATE("1"), FIND_ALL("2"), REMOVE_OLDER("3"), FIND_OVER("4"), EXIT("exit");

    private final String option;

    MenuOption(String option) {
        this.option = option;
    }

    public static MenuOption from (String input) {
        return Arrays.stream(MenuOption.values())
                    .filter((menuOption) -> menuOption.option.equals(input))
                    .findFirst().orElseThrow(()-> new IllegalArgumentException(INPUT_INVALID_MENU_OPTION));
    }
}