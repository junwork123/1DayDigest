package com.oneday.digest.domains.core.entity.lotto;

import java.util.Objects;

public record LottoNumber(int numbers) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber that)) return false;
        return numbers == that.numbers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
