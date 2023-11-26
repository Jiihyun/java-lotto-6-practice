package lotto.view;

import lotto.domain.dto.DrawResultsResponse;
import lotto.domain.dto.LottoResponse;
import lotto.domain.dto.PurchasedLottosResponse;
import lotto.io.writer.Writer;

import static lotto.view.constants.PrintFormat.PURCHASED_AMOUNT_FORMAT;
import static lotto.view.constants.PrintFormat.STATISTICS_FORMAT;

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

    public void printDrawResults(DrawResultsResponse drawResultsResponse) {
        writer.writef(STATISTICS_FORMAT.getFormat(),
                drawResultsResponse.fifth(),
                drawResultsResponse.fourth(),
                drawResultsResponse.third(),
                drawResultsResponse.second(),
                drawResultsResponse.first());
    }
}
