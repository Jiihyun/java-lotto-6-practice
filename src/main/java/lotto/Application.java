package lotto;

import lotto.controller.ProgramController;
import lotto.io.reader.ConsoleReader;
import lotto.io.writer.ConsoleWriter;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.RetryHandler;

public class Application {
    public static void main(String[] args) {
        ProgramController programController = getProgramController();
        programController.start();
    }

    private static ProgramController getProgramController() {
        ConsoleWriter writer = new ConsoleWriter();
        ConsoleReader reader = new ConsoleReader();
        RetryHandler retryHandler = new RetryHandler(writer);
        InputView inputView = new InputView(writer, reader, retryHandler);
        OutputView outputView = new OutputView(writer);

        return new ProgramController(inputView, outputView);
    }
}
