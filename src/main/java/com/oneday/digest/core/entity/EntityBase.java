package com.oneday.digest.core.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class EntityBase {
    static {
        gsonBuilder = new GsonBuilder();
    }
    public static GsonBuilder gsonBuilder;
    @Override
    public String toString() {
        return new Gson().toJson(getClass());
    }
}
