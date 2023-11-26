package lotto.domain.dto;

import java.util.List;

public record PurchasedLottosResponse(int quantity, List<LottoResponse> purchasedLottoNumbers) {
}
