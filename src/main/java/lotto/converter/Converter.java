package lotto.converter;

import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

import static lotto.exception.ExceptionMessage.INPUT_NUMBER_FORMAT;
import static lotto.validator.InputValidator.validateBlank;

public class Converter {
    private static final String DELIMITER = ",";

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

    public static List<Integer> convertToList(String input) {
        InputValidator.validateRegex(input);
        return Arrays.stream(input.split(DELIMITER))
                .map(Converter::convertToInt)
                .toList();
    }
}
