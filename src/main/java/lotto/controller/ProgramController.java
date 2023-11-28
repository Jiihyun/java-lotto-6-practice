package lotto.controller;

import lotto.domain.DrawMachine;
import lotto.domain.PurchaseAmount;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningNumbers;
import lotto.domain.dto.DrawResultsResponse;
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
        PurchasedLottos purchasedLottos = purchasedLottos();
        draw(purchasedLottos);
    }

    private PurchasedLottos purchasedLottos() {
        PurchaseAmount purchaseAmount = inputView.readPurchaseAmount();
        PurchasedLottos purchasedLottos = PurchasedLottos.from(purchaseAmount.getPurchasedLottoQuantity());
        PurchasedLottosResponse purchasedLottosResponse = purchasedLottos.toPurchasedLottosResponse();
        outputView.printPurchasedTicket(purchasedLottosResponse);
        return purchasedLottos;
    }

    private void draw(PurchasedLottos purchasedLottos) {
        WinningNumbers winningNumbers = inputView.readWinningNumbers();
        DrawMachine drawMachine = DrawMachine.from(winningNumbers);
        DrawResultsResponse drawResultsResponse = drawMachine.drawAll(purchasedLottos);
        outputView.printDrawResults(drawResultsResponse);
    }
}
