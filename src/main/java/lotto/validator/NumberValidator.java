package lotto.validator;

import lotto.domain.Lotto;
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

    public static void validateBonusNumber(Lotto winningNumber, int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateDuplicateWithWinningNumber(winningNumber, bonusNumber);

    }

    private static void validateDuplicateWithWinningNumber(Lotto winningNumber, int bonusNumber) {
        if (isDuplicatedWith(winningNumber, bonusNumber)) {
            throw ExceptionMessage.DUPLICATED_LOTTO_NUMBER.getException();
        }
    }

    private static boolean isDuplicatedWith(Lotto winningNumber, int number) {
        return winningNumber.getNumbers().stream().anyMatch(num -> num.equals(number));
    }
}
