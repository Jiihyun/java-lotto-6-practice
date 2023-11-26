package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }
}
