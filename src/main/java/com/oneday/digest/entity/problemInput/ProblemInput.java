package com.oneday.digest.entity.problemInput;

import com.oneday.digest.entity.problem.Problem;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class ProblemInput {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = Problem.class)
    @JoinColumn(name = "problem_id", updatable = false)
    private Problem problem;

    @Column(nullable = false)
    private String[] input;

    @Column(nullable = false)
    private String[] output;

    @Builder
    public ProblemInput(Problem problem, String[] input, String[] output) {
        this.problem = problem;
        this.input = input;
        this.output = output;
    }
}
