package com.oneday.digest.entity.web;

import com.oneday.digest.entity.metaInfo.Language;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class ProblemRequest {
    private Long id;
    private String title;
    private String url;
    private Language language;
    private List<String[]> inputs;
    private List<String[]> outputs;

    @Builder
    public ProblemRequest(Long id, String title, String url, Language language, List<String[]> inputs, List<String[]> outputs) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.language = language;
        this.inputs = inputs;
        this.outputs = outputs;
    }
}
