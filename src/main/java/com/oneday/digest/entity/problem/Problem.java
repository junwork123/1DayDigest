package com.oneday.digest.entity.problem;

import com.oneday.digest.entity.metaInfo.Language;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Problem {
    @Id
    @Column(unique = true, nullable = false)
    private Long id;
    private String title;
    private String url;
    private Language language;

    @Builder
    public Problem(Long id, String title, String url, Language language) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.language = language;
    }
}


