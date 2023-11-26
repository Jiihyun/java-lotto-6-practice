package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.domain.PurchasedLottos;
import lotto.domain.dto.PurchasedLottosResponse;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ProgramController {
    private final InputView inputView;
    private final OutputView outputView;

    public ProgramController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        PurchaseAmount purchaseAmount = inputView.readPurchaseAmount();
        PurchasedLottos purchasedLottos = PurchasedLottos.from(purchaseAmount.getPurchasedLottoQuantity());
        PurchasedLottosResponse purchasedLottosResponse = purchasedLottos.toPurchasedLottosResponse();
        outputView.printPurchasedTicket(purchasedLottosResponse);
    }
}
