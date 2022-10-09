package com.oneday.digest.entity.metaInfo;

public enum Language {
    JAVA("java"),
    CPP("cpp"),
    PYTHON("python3");

    final private String language;

    Language(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
