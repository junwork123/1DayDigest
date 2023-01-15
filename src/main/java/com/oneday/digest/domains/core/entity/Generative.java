package com.oneday.digest.domains.core.entity;

@FunctionalInterface
public interface Generative<T>{
    T generate();
}
