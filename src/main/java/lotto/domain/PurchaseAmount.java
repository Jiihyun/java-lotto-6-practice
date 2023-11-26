package lotto.domain;

import lotto.validator.PurChaseAmountValidator;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1_000;
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        PurChaseAmountValidator.validateMinimumAmount(purchaseAmount);
        PurChaseAmountValidator.validateMultipleOfLottoPrice(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getLottoPurchaseCount() {
        return purchaseAmount / LOTTO_PRICE;
    }


}
