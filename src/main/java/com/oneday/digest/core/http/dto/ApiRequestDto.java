package com.oneday.digest.core.http.dto;

@FunctionalInterface
public interface ApiRequestDto<T> {
    T toServiceDto();
}
