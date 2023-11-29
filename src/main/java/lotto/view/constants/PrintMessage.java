package lotto.view.constants;

public enum PrintMessage {
    /*
    InputView
     */
    INPUT_PURCHASE_AMOUNT_MSG("구입금액을 입력해 주세요"),
    INPUT_WINNING_NUMBER_MSG(System.lineSeparator() + "당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MSG(System.lineSeparator() + "보너스 번호를 입력해 주세요.");
   /*
   OutputView
    */

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
