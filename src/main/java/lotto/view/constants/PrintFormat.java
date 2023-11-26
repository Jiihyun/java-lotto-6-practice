package lotto.view.constants;

public enum PrintFormat {
    PURCHASED_AMOUNT_FORMAT(System.lineSeparator() + "%d개를 구매했습니다." + System.lineSeparator());
    private final String format;

    PrintFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
