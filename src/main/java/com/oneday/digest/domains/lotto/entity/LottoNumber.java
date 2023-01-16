package com.oneday.digest.domains.lotto.entity;

import java.util.Objects;

public record LottoNumber(int value) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber that)) return false;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
