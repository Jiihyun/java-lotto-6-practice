package lotto.exception;

public enum ExceptionMessage {
    INPUT_BLANK("입력값이 공백입니다."),
    INPUT_NUMBER_FORMAT("숫자만 입력해주세요."),
    INPUT_REGEX_FORMAT("6개의 숫자를 ,를 사용하여 공백없이 입력해주세요."),
    PRICE_OUT_OF_RANGE("최소 1_000원 이상 100_000원 이하로 구매하셔야 합니다."),
    NON_DIVISIBLE_AMOUNT("로또 가격과 나누어 떨어지지 않습니다."),
    LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_RANGE("번호는 1 - 45 사이내에 존재해야 합니다."),
    DUPLICATED_LOTTO_NUMBER("중복된 번호가 존재합니다.");
    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = PREFIX + message;
    }

    public ProgramException getException() {
        return new ProgramException(this.message);
    }
}
