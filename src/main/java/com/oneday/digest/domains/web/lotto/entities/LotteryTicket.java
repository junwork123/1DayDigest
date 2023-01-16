package com.oneday.digest.domains.web.lotto.entities;

import com.oneday.digest.domains.core.entity.EntityBase;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class LotteryTicket extends EntityBase {
    private final List<LottoNumber> lottoNumbers;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LotteryTicket that)) return false;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }
    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
