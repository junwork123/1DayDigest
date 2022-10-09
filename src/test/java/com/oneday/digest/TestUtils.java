package com.oneday.digest;

import com.oneday.digest.entity.metaInfo.Language;
import com.oneday.digest.entity.problem.Problem;
import com.oneday.digest.entity.problemInput.ProblemInput;

public class TestUtils {
    public static Problem getProblem(){
        return Problem.builder()
                .id(12865L)
                .title("평범한 배낭")
                .url("https://www.acmicpc.net/problem/12865")
                .language(Language.JAVA).build();
    }
    public static ProblemInput getProblemInput(){
        return ProblemInput.builder()
                .problem(getProblem())
                .input(new String[]{"4 7", "6 13", "4 8", "3 6", "5 12"})
                .output(new String[]{"14"})
                .build();
    }
}
