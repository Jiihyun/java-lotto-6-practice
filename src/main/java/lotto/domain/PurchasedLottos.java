package lotto.domain;

import lotto.domain.dto.LottoResponse;
import lotto.domain.dto.PurchasedLottosResponse;

import java.util.List;
import java.util.stream.Stream;

public class PurchasedLottos {
    private final int purchasedLottoQuantity;
    private final List<Lotto> purchasedLottoNumbers;

    private PurchasedLottos(int purchasedLottoQuantity, List<Lotto> purchasedLottoNumbers) {
        this.purchasedLottoQuantity = purchasedLottoQuantity;
        this.purchasedLottoNumbers = purchasedLottoNumbers;
    }

    public static PurchasedLottos from(int purchasedLottoQuantity) {
        List<Lotto> purchasedLottoNumbers = Stream.generate(() -> new Lotto(RandomlyLottoNumberGenerator.generate()))
                .limit(purchasedLottoQuantity)
                .toList();
        return new PurchasedLottos(purchasedLottoQuantity, purchasedLottoNumbers);
    }

    //QUESTION: LottoResponse dto 감싸는 거 맞는지
    public PurchasedLottosResponse toPurchasedLottosResponse() {
        List<LottoResponse> purchasedLottoNumbersResponse = purchasedLottoNumbers.stream()
                .map(Lotto::toLottoResponse)
                .toList();
        return new PurchasedLottosResponse(purchasedLottoQuantity, purchasedLottoNumbersResponse);
    }

    //QUESTION: 게터 어떻게 없애지
    public List<Lotto> getPurchasedLottoNumbers() {
        return purchasedLottoNumbers;
    }
}
