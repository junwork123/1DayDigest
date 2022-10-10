package com.oneday.digest.algorithm;

import com.oneday.digest.algorithm.CalculationService;
import com.oneday.digest.entity.metaInfo.Language;
import com.oneday.digest.entity.problem.Problem;
import com.oneday.digest.entity.problem.ProblemRepository;
import com.oneday.digest.entity.problemCase.ProblemCase;
import com.oneday.digest.entity.problemCase.ProblemCaseRepository;
import com.oneday.digest.entity.web.ProblemRequest;
import com.oneday.digest.utils.ProblemUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class ProblemSolvingService {
    @Autowired
    ProblemRepository problemRepository;

    @Autowired
    ProblemCaseRepository inputRepository;

    @Autowired
    CalculationService calculationService;

    @Transactional
    private Problem appendProblem(Long id, String title, Language language) {
        Problem problem = Problem.builder()
                .id(id)
                .title(title)
                .url(ProblemUtils.getBaekJoonProblemUrl(id))
                .language(language).build();
        problemRepository.save(problem);
        return problem;
    }
    @Transactional
    private void appendCases(Long problemId, List<String[]> inputs, List<String[]> outputs) {
        if(inputs.size() != outputs.size()) {
            throw new IllegalArgumentException("input size and output size must be same");
        }
        for(int i = 0; i < inputs.size(); i++) {
            ProblemCase input = ProblemCase.builder()
                    .problemId(problemId)
                    .input(inputs.get(i))
                    .output(outputs.get(i))
                    .build();
            inputRepository.save(input);
        }
    }

    private List<String[]> solveEachCases(Long id) {
        List<ProblemCase> cases = inputRepository.findAllById(Collections.singleton(id));
        List<String[]> results = new ArrayList<>();
        for (ProblemCase item : cases) {
            log.info(Arrays.toString(item.getInput()));
            results.add(calculationService.calculate(item.getInput()));
            log.info(Arrays.toString(item.getOutput()));
        }
        return results;
    }
    public List<String[]> solve(ProblemRequest request){
        appendProblem(request.getId(), request.getTitle(), request.getLanguage());
        appendCases(request.getId(), request.getInputs(), request.getOutputs());
        return solveEachCases(request.getId());
    }


}
