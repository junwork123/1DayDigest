package com.oneday.digest.entity.web;

import com.oneday.digest.entity.metaInfo.Language;
import lombok.Builder;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class ProblemResponse {
    private String[] output;

    @Builder
    public ProblemResponse(String[] output) {
        this.output = output;
    }

}
