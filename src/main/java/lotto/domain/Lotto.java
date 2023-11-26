package lotto.domain;

import lotto.domain.dto.LottoResponse;
import lotto.validator.LottoValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateLotto(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    public LottoResponse toLottoResponse() {
        return new LottoResponse(numbers);
    }
}
