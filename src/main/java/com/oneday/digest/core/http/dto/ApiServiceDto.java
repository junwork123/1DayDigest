package com.oneday.digest.core.http.dto;

@FunctionalInterface
public interface ApiServiceDto<T>{
    T toEntity();
}
