package lotto.domain;

import java.util.List;

public enum LottoRank {
    NONE(0, 0),
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3);
    private static final List<LottoRank> results = List.of(values());
    private final int prizeAmount;
    private final int matchingNumber;

    LottoRank(int prizeAmount, int matchingNumber) {
        this.prizeAmount = prizeAmount;
        this.matchingNumber = matchingNumber;
    }

    public static LottoRank of(int matchingNumber, boolean hasBonusNumber) {
        if (matchingNumber == SECOND.matchingNumber && hasBonusNumber) {
            return SECOND;
        }
        return results.stream()
                .filter(lottoRank -> lottoRank.matchingNumber == matchingNumber)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getMatchingNumber() {
        return matchingNumber;
    }
}
