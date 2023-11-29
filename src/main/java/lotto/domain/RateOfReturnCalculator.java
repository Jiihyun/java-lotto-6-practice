package lotto.domain;

public class RateOfReturnCalculator {
    private double totalPrizeAmount = 0;
    private double totalPurchasedAmount = 0;

    public void updateAmount(LottoRank lottoRank) {
        totalPrizeAmount += lottoRank.getPrizeAmount();
        totalPurchasedAmount += PurchaseAmount.LOTTO_PRICE;
    }

    public double calculateRateOfReturn() {
        double rateOfReturn = (totalPrizeAmount / totalPurchasedAmount) * 100.0;
        return Math.round(rateOfReturn * 10.0) / 10.0;
    }
}