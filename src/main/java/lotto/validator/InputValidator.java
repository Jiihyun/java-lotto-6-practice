package lotto.validator;

import lotto.exception.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String REGEX = "\\d+(,\\d+)*";

    private InputValidator() {
        throw new AssertionError();
    }

    public static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw ExceptionMessage.INPUT_BLANK.getException();
        }
    }

    public static void validateRegex(String input) {
        if (!Pattern.matches(REGEX, input)) {
            throw ExceptionMessage.INPUT_REGEX_FORMAT.getException();
        }
    }
}
