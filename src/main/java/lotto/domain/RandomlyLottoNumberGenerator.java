package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.domain.LottoRule.*;

public class RandomlyLottoNumberGenerator {

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE_OF_NUMBER.getValue(),
                END_INCLUSIVE_OF_NUMBER.getValue(),
                LOTTO_SIZE.getValue());
    }
}
