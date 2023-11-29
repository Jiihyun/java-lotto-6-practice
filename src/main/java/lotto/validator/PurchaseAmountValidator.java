package lotto.validator;

import lotto.exception.ExceptionMessage;

public class PurchaseAmountValidator {
    private static final int MINIMUM_PURCHASE_AMOUNT = 1_000;
    private static final int MAXIMUM_PURCHASE_AMOUNT = 100_000;

    private PurchaseAmountValidator() {
        throw new AssertionError();
    }

    public static void validateMinimumAmount(int purchaseAmount) {
        if (purchaseAmount > MAXIMUM_PURCHASE_AMOUNT || purchaseAmount < MINIMUM_PURCHASE_AMOUNT) {
            throw ExceptionMessage.PRICE_OUT_OF_RANGE.getException();
        }
    }

    public static void validateMultipleOfLottoPrice(int purchaseAmount) {
        if (purchaseAmount % MINIMUM_PURCHASE_AMOUNT != 0) {
            throw ExceptionMessage.NON_DIVISIBLE_AMOUNT.getException();
        }
    }
}
