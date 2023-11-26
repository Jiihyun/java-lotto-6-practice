package lotto.validator;

import lotto.exception.ExceptionMessage;

import static lotto.domain.LottoRule.END_INCLUSIVE_OF_NUMBER;
import static lotto.domain.LottoRule.START_INCLUSIVE_OF_NUMBER;

public class NumberValidator {

    private NumberValidator() {
        throw new AssertionError();
    }

    public static void validateNumberRange(int number) {
        if (number < START_INCLUSIVE_OF_NUMBER.getValue() || number > END_INCLUSIVE_OF_NUMBER.getValue()) {
            throw ExceptionMessage.LOTTO_NUMBER_RANGE.getException();
        }
    }
}
