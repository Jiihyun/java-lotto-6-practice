package lotto.exception;

public enum ExceptionMessage {
    INPUT_BLANK("입력값이 공백입니다."),
    INPUT_NUMBER_FORMAT("숫자만 입력해주세요."),
    INPUT_REGEX_FORMAT("6개의 숫자를 ,를 사용하여 공백없이 입력해주세요.");
    private static final String PREFIX = "[ERROR]";
    private final String message;

    ExceptionMessage(String message) {
        this.message = PREFIX + message;
    }

    public ProgramException getException() {
        return new ProgramException(this.message);
    }
}
