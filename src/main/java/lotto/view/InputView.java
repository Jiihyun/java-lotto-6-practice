package lotto.view;

import lotto.converter.Converter;
import lotto.domain.PurchaseAmount;
import lotto.io.reader.Reader;
import lotto.io.writer.Writer;

import static lotto.view.constants.PrintMessage.INPUT_PURCHASE_AMOUNT_MSG;

public class InputView {
    private final Writer writer;
    private final Reader reader;
    private final RetryHandler retryHandler;

    public InputView(Writer writer, Reader reader, RetryHandler retryHandler) {
        this.writer = writer;
        this.reader = reader;
        this.retryHandler = retryHandler;
    }

    public PurchaseAmount readPurchaseAmount() {
        return retryHandler.retryUntilSuccess(this::getPurchaseAmount);
    }

    private PurchaseAmount getPurchaseAmount() {
        writer.writeln(INPUT_PURCHASE_AMOUNT_MSG.getMessage());
        int purchaseAmount = Converter.convertToInt(reader.readLine());
        return new PurchaseAmount(purchaseAmount);
    }
}
