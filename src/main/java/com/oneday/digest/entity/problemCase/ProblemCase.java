package com.oneday.digest.entity.problemCase;

import com.oneday.digest.entity.problem.Problem;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class ProblemCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = Problem.class)
    @JoinColumn(name = "problem_id", updatable = false)
    private Long problemId;

    @Column(nullable = false)
    private String[] input;

    @Column(nullable = false)
    private String[] output;

    @Builder
    public ProblemCase(Long problemId, String[] input, String[] output) {
        this.problemId = problemId;
        this.input = input;
        this.output = output;
    }
}
