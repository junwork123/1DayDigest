package com.oneday.digest.entity.web;

import com.oneday.digest.entity.metaInfo.Language;
import com.oneday.digest.entity.problemInput.ProblemInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProblemRequest {
    private Long id;
    private String title;
    private String url;
    private Language language;
    private String[] input;
    private String[] output;

    @Builder
    public ProblemRequest(Long id, String title, String url, Language language, String[] input, String[] output) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.language = language;
        this.input = input;
        this.output = output;
    }

    public static ProblemRequest of(ProblemInput request) {
        return ProblemRequest.builder()
                .id(request.getId())
                .title(request.getProblem().getTitle())
                .language(request.getProblem().getLanguage())
                .input(request.getInput())
                .output(request.getOutput())
                .build();
    }
}
