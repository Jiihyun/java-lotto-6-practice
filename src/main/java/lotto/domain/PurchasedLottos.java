package lotto.domain;

import lotto.domain.dto.LottoResponse;
import lotto.domain.dto.PurchasedLottosResponse;

import java.util.List;
import java.util.stream.Stream;

public class PurchasedLottos {
    private final List<Lotto> purchasedLottoNumbers;

    private PurchasedLottos(List<Lotto> purchasedLottoNumbers) {
        this.purchasedLottoNumbers = purchasedLottoNumbers;
    }

    public static PurchasedLottos from(PurchaseAmount purchaseAmount) {
        List<Lotto> purchasedLottoNumbers = Stream.generate(() -> new Lotto(RandomlyLottoNumberGenerator.generate()))
                .limit(purchaseAmount.getPurchasedLottoQuantity())
                .toList();
        return new PurchasedLottos(purchasedLottoNumbers);
    }

    //QUESTION: LottoResponse dto 감싸는 거 맞는지
    public PurchasedLottosResponse toPurchasedLottosResponse() {
        int quantity = purchasedLottoNumbers.size();
        List<LottoResponse> lottoNumbers = purchasedLottoNumbers.stream()
                .map(Lotto::toLottoResponse)
                .toList();
        return new PurchasedLottosResponse(quantity, lottoNumbers);
    }

    //QUESTION: 게터 어떻게 없애지
    public List<Lotto> getPurchasedLottoNumbers() {
        return purchasedLottoNumbers;
    }
}
