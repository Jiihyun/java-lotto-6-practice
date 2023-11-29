package lotto.domain;

import lotto.domain.dto.DrawResultsResponse;

import java.util.EnumMap;
import java.util.Map;

public class DrawMachine {
    private final Map<LottoRank, Integer> statistics;
    private final WinningNumbers winningNumbers;
    private final RateOfReturnCalculator rateOfReturnCalculator;

    private DrawMachine(Map<LottoRank, Integer> statistics, WinningNumbers winningNumbers, RateOfReturnCalculator rateOfReturnCalculator) {
        this.statistics = statistics;
        this.winningNumbers = winningNumbers;
        this.rateOfReturnCalculator = rateOfReturnCalculator;
    }

    public static DrawMachine from(WinningNumbers winningNumbers) {
        return new DrawMachine(createStatistics(),
                winningNumbers,
                new RateOfReturnCalculator());
    }

    private static Map<LottoRank, Integer> createStatistics() {
        Map<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            statistics.put(lottoRank, 0);
        }
        return statistics;
    }

    public DrawResultsResponse drawAll(PurchasedLottos purchasedLottos) {
        for (Lotto purchasedLottoNumber : purchasedLottos.getPurchasedLottoNumbers()) {
            updateStatistics(statistics, purchasedLottoNumber);
        }
        return new DrawResultsResponse(
                statistics.get(LottoRank.FIFTH),
                statistics.get(LottoRank.FOURTH),
                statistics.get(LottoRank.THIRD),
                statistics.get(LottoRank.SECOND),
                statistics.get(LottoRank.FIRST),
                rateOfReturnCalculator.calculateRateOfReturn());
    }


    private void updateStatistics(Map<LottoRank, Integer> statistics, Lotto purchasedLottoNumber) {
        LottoRank lottoRank = draw(purchasedLottoNumber);
        statistics.put(lottoRank, statistics.get(lottoRank) + 1);
        rateOfReturnCalculator.updateAmount(lottoRank);
    }

    private LottoRank draw(Lotto purchasedLotto) {
        int matchingNumber = winningNumbers.getMatchingNumber(purchasedLotto);
        boolean hasBonusNumber = winningNumbers.hasBonusNumber(purchasedLotto);
        return LottoRank.of(matchingNumber, hasBonusNumber);
    }
}
