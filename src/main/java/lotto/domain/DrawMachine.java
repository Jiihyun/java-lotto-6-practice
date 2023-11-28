package lotto.domain;

import lotto.domain.dto.DrawResultsResponse;

import java.util.EnumMap;
import java.util.Map;

public class DrawMachine {
    private final Map<LottoRank, Integer> statistics;
    private final WinningNumbers winningNumbers;
    private double totalPrizeAmount = 0;
    private double totalPurchasedAmount = 0;

    public DrawMachine(Map<LottoRank, Integer> statistics, WinningNumbers winningNumbers) {
        this.statistics = statistics;
        this.winningNumbers = winningNumbers;
    }

    public static DrawMachine from(WinningNumbers winningNumbers) {
        return new DrawMachine(createStatistics(), winningNumbers);
    }

    private static Map<LottoRank, Integer> createStatistics() {
        Map<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            statistics.put(lottoRank, 0);
        }
        return statistics;
    }

    public DrawResultsResponse drawAll(PurchasedLottos purchasedLottos) {
        Map<LottoRank, Integer> statistics = createStatistics();

        for (Lotto purchasedLottoNumber : purchasedLottos.getPurchasedLottoNumbers()) {
            updateStatistics(statistics, purchasedLottoNumber);
        }
        return new DrawResultsResponse(
                statistics.get(LottoRank.FIFTH),
                statistics.get(LottoRank.FOURTH),
                statistics.get(LottoRank.THIRD),
                statistics.get(LottoRank.SECOND),
                statistics.get(LottoRank.FIRST),
                getRateOfReturn());
    }


    private void updateStatistics(Map<LottoRank, Integer> statistics, Lotto purchasedLottoNumber) {
        LottoRank lottoRank = draw(purchasedLottoNumber);
        totalPrizeAmount += lottoRank.getPrizeAmount();
        totalPurchasedAmount += PurchaseAmount.LOTTO_PRICE;
        statistics.put(lottoRank, statistics.get(lottoRank) + 1);
    }

    public LottoRank draw(Lotto purchasedLotto) {
        int matchingNumber = winningNumbers.getMatchingNumber(purchasedLotto);
        boolean hasBonusNumber = winningNumbers.hasBonusNumber(purchasedLotto);
        return LottoRank.of(matchingNumber, hasBonusNumber);
    }

    private double getRateOfReturn() {
        double rateOfReturn = (totalPrizeAmount / totalPurchasedAmount) * 100.0;
        return Math.round(rateOfReturn * 10.0) / 10.0;
    }
}
