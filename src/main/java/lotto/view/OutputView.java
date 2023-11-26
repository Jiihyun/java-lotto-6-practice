package lotto.view;

import lotto.domain.dto.LottoResponse;
import lotto.domain.dto.PurchasedLottosResponse;
import lotto.io.writer.Writer;

import static lotto.view.constants.PrintFormat.PURCHASED_AMOUNT_FORMAT;

public class OutputView {
    private final Writer writer;

    public OutputView(Writer writer) {
        this.writer = writer;
    }

    public void printPurchasedTicket(PurchasedLottosResponse purchasedLottosResponse) {
        writer.writef(PURCHASED_AMOUNT_FORMAT.getFormat(), purchasedLottosResponse.quantity());
        for (LottoResponse purchasedLottoNumber : purchasedLottosResponse.purchasedLottoNumbers()) {
            writer.writeln(purchasedLottoNumber.numbers().toString());
        }
    }
}
