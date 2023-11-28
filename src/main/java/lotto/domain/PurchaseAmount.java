package lotto.domain;

import lotto.validator.PurchaseAmountValidator;

public class PurchaseAmount {
    public static final int LOTTO_PRICE = 1_000;
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        PurchaseAmountValidator.validateMinimumAmount(purchaseAmount);
        PurchaseAmountValidator.validateMultipleOfLottoPrice(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchasedLottoQuantity() {
        return purchaseAmount / LOTTO_PRICE;
    }


}
