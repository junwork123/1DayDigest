package com.oneday.digest;

import com.oneday.digest.entity.metaInfo.Language;
import com.oneday.digest.entity.problem.Problem;
import com.oneday.digest.entity.problemCase.ProblemCase;

public class TestUtils {
    public static Problem getProblem(){
        return Problem.builder()
                .id(12865L)
                .title("평범한 배낭")
                .url("https://www.acmicpc.net/problem/12865")
                .language(Language.JAVA).build();
    }
    public static ProblemCase getProblemInput(){
        return ProblemCase.builder()
                .problemId(12865L)
                .input(new String[]{"4 7", "6 13", "4 8", "3 6", "5 12"})
                .output(new String[]{"14"})
                .build();
    }
}
