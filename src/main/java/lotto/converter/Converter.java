package lotto.converter;

import static lotto.exception.ExceptionMessage.INPUT_NUMBER_FORMAT;
import static lotto.validator.InputValidator.validateBlank;

public class Converter {
    private Converter() {
        throw new AssertionError();
    }

    public static int convertToInt(String input) {
        try {
            validateBlank(input);
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw INPUT_NUMBER_FORMAT.getException();
        }
    }
}
