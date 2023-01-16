package com.oneday.digest.domains.lotto.entity;

import com.oneday.digest.core.entity.Generative;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@Getter
@AllArgsConstructor
public enum LottoType implements Generative<LotteryTicket> {
    KOREAN_LOTTO(1, 45, 6);
    private final int min;
    private final int max;
    private final int maxSize;
    @Override
    public LotteryTicket generate(){
        Set<LottoNumber> numbers = new HashSet<>();
        Random rand = new Random();
        while (numbers.size() < maxSize) {
            numbers.add(new LottoNumber(rand.nextInt(max) + min));
        }
        return new LotteryTicket(numbers.stream().toList());
    }
}
