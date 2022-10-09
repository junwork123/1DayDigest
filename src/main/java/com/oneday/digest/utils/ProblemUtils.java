package com.oneday.digest.utils;

import com.oneday.digest.entity.metaInfo.Language;

public class ProblemUtils {
    public static String getBaekJoonProblemUrl(Long id){
        return "https://www.acmicpc.net/problem/" + id;
    }

    public static String getBaekJoonProblemUrl(String id, Language language){
        return "https://www.acmicpc.net/problem/" + id + "/source/" + language.getLanguage();
    }
}
