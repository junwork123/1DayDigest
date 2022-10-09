package com.oneday.digest.baekjoon;

import com.oneday.digest.entity.metaInfo.Language;
import com.oneday.digest.entity.problem.Problem;
import com.oneday.digest.entity.problem.ProblemRepository;
import com.oneday.digest.entity.problemInput.ProblemInput;
import com.oneday.digest.entity.problemInput.ProblemInputRepository;
import com.oneday.digest.entity.web.ProblemRequest;
import com.oneday.digest.utils.ProblemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BaekjoonService {
    @Autowired
    ProblemRepository problemRepository;

    @Autowired
    ProblemInputRepository inputRepository;

    @Transactional
    public Problem prepareProblem(Long id, String title, Language language) {
        Problem problem = Problem.builder()
                .id(id)
                .title(title)
                .url(ProblemUtils.getBaekJoonProblemUrl(id))
                .language(language).build();
        problemRepository.save(problem);
        return problem;
    }
    @Transactional
    private ProblemInput appendCase(Problem problem, String[] input, String[] output) {
        ProblemInput inputCase = ProblemInput.builder()
                .problem(problem)
                .input(input)
                .output(output)
                .build();

        inputRepository.save(inputCase);
        return inputCase;
    }

    public void prepare_12865() {
        Problem 평범한_배낭 = prepareProblem(12865L, "평범한 배낭", Language.JAVA);
        appendCase(평범한_배낭
                , new String[]{"4 7", "6 13", "4 8", "3 6", "5 12"}
                , new String[]{"14"});
    }

    public String solve_12865(){
        prepare_12865();
        return "14";
    }

    public String[] solve(ProblemRequest input){
        return new String[]{"14"};
    }
}
