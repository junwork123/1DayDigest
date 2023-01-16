package com.oneday.digest.core.entity;

@FunctionalInterface
public interface Generative<T>{
    T generate();
}
