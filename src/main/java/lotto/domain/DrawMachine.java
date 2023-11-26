package lotto.domain;

import lotto.domain.dto.DrawResultsResponse;

import java.util.EnumMap;
import java.util.Map;

public class DrawMachine {
    private final WinningNumbers winningNumbers;

    private DrawMachine(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static DrawMachine from(WinningNumbers winningNumbers) {
        return new DrawMachine(winningNumbers);
    }

    public Map<LottoRank, Integer> createStatistics() {
        Map<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            statistics.put(lottoRank, 0);
        }
        return statistics;
    }

    public DrawResultsResponse drawAll(PurchasedLottos purchasedLottos) {
        Map<LottoRank, Integer> statistics = createStatistics();
        for (Lotto purchasedLottoNumber : purchasedLottos.getPurchasedLottoNumbers()) {
            LottoRank lottoRank = draw(purchasedLottoNumber);
            statistics.put(lottoRank, statistics.get(lottoRank) + 1);
        }
        return new DrawResultsResponse(
                statistics.get(LottoRank.FIFTH),
                statistics.get(LottoRank.FOURTH),
                statistics.get(LottoRank.THIRD),
                statistics.get(LottoRank.SECOND),
                statistics.get(LottoRank.FIRST));
    }

    public LottoRank draw(Lotto purchasedLotto) {
        int matchingNumber = winningNumbers.getMatchingNumber(purchasedLotto);
        boolean hasBonusNumber = winningNumbers.hasBonusNumber(purchasedLotto);
        return LottoRank.of(matchingNumber, hasBonusNumber);
    }
}
