package com.oneday.digest.entity.web;

import com.oneday.digest.entity.metaInfo.Language;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Getter
public class ProblemResponse {
    private List<String[]> results;

    @Builder
    public ProblemResponse(List<String[]> results) {
        this.results = results;
    }

}
