package lotto.validator;

import lotto.exception.ExceptionMessage;

import java.util.List;

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

    public static void validateBonusNumber(List<Integer> winningNumber, int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateDuplicateWithWinningNumber(winningNumber, bonusNumber);

    }

    private static void validateDuplicateWithWinningNumber(List<Integer> winningNumber, int bonusNumber) {
        if (isDuplicatedWith(winningNumber, bonusNumber)) {
            throw ExceptionMessage.DUPLICATED_LOTTO_NUMBER.getException();
        }
    }

    private static boolean isDuplicatedWith(List<Integer> winningNumber, int number) {
        return winningNumber.stream().anyMatch(num -> num.equals(number));
    }
}
