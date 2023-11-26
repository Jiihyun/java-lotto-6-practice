package lotto.domain;

import lotto.validator.LottoValidator;
import lotto.validator.NumberValidator;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumber, int bonusNumber) {
        LottoValidator.validateLotto(winningNumber);
        NumberValidator.validateBonusNumber(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public int getMatchingNumber(Lotto purchasedLotto) {
        return (int) winningNumber.stream()
                .filter(num -> purchasedLotto.getNumbers().contains(num))
                .count();
    }

    public boolean hasBonusNumber(Lotto purchasedLotto) {
        return purchasedLotto.getNumbers()
                .stream()
                .anyMatch(num -> num.equals(bonusNumber));
    }
}
