package lotto.domain;

public enum LottoRule {
    LOTTO_SIZE(6),
    START_INCLUSIVE_OF_NUMBER(1),
    END_INCLUSIVE_OF_NUMBER(45);

    private final int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
