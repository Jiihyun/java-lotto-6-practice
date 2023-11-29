package lotto.domain;

import lotto.validator.NumberValidator;

public class WinningNumbers {
    private final Lotto winningNumber;
    private final int bonusNumber;

    public WinningNumbers(Lotto winningNumber, int bonusNumber) {
        NumberValidator.validateBonusNumber(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public int getMatchingNumber(Lotto purchasedLotto) {
        return (int) winningNumber.getNumbers().stream()
                .filter(num -> purchasedLotto.getNumbers().contains(num))
                .count();
    }

    public boolean hasBonusNumber(Lotto purchasedLotto) {
        return purchasedLotto.getNumbers()
                .stream()
                .anyMatch(num -> num.equals(bonusNumber));
    }
}
