package lotto.view.constants;

public enum PrintFormat {
    PURCHASED_AMOUNT_FORMAT(System.lineSeparator() +
            "%d개를 구매했습니다." +
            System.lineSeparator()),
    STATISTICS_FORMAT(System.lineSeparator() +
            "당첨 통계" + System.lineSeparator() +
            "---" + System.lineSeparator() +
            "3개 일치 (5,000원) - %d개" + System.lineSeparator() +
            "4개 일치 (50,000원) - %d개" + System.lineSeparator() +
            "5개 일치 (1,500,000원) -%d개" + System.lineSeparator() +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개" + System.lineSeparator() +
            "6개 일치 (2,000,000,000원) - %d개" + System.lineSeparator() +
            "총 수익률은 %,.1f%%입니다.");
    private final String format;

    PrintFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
