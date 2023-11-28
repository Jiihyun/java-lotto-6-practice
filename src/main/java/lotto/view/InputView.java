package lotto.view;

import lotto.converter.Converter;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.io.reader.Reader;
import lotto.io.writer.Writer;

import java.util.List;

import static lotto.view.constants.PrintMessage.*;

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

    public WinningNumbers readWinningNumbers() {
        Lotto winningNumber = retryHandler.retryUntilSuccess(this::getWinningNumber);
        return retryHandler.retryUntilSuccess(() -> {
            int bonusNumber = getBonusNumber();
            return new WinningNumbers(winningNumber, bonusNumber);
        });
    }

    private Lotto getWinningNumber() {
        writer.writeln(INPUT_WINNING_NUMBER_MSG.getMessage());
        List<Integer> numbers = Converter.convertToList(reader.readLine());
        return new Lotto(numbers);
    }

    private int getBonusNumber() {
        writer.writeln(INPUT_BONUS_NUMBER_MSG.getMessage());
        return Converter.convertToInt(reader.readLine());
    }
}
