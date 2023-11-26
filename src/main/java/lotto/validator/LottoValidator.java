package lotto.validator;

import lotto.exception.ExceptionMessage;

import java.util.List;

import static lotto.domain.LottoRule.LOTTO_SIZE;

public class LottoValidator {
    private LottoValidator() {
        throw new AssertionError();
    }

    public static void validateLotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateRagne(numbers);
        validateDuplicatedNumber(numbers);
    }

    private static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateRagne(List<Integer> numbers) {
        for (Integer number : numbers) {
            NumberValidator.validateNumberRange(number);
        }
    }

    private static void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE.getValue()) {
            throw ExceptionMessage.DUPLICATED_LOTTO_NUMBER.getException();
        }
    }
}
