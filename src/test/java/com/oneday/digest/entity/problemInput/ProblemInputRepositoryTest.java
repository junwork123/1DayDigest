package com.oneday.digest.entity.problemInput;

import com.oneday.digest.entity.metaInfo.Language;
import com.oneday.digest.entity.problem.Problem;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.oneday.digest.TestUtils.getProblemInput;

@DataJpaTest
class ProblemInputRepositoryTest {

    @Autowired
    private ProblemInputRepository problemInputRepository;

    @DisplayName("문제 입력 저장")
    @Test
    public void saveTest(){
        ProblemInput problemInput = getProblemInput();
        ProblemInput save = problemInputRepository.save(problemInput);
        Assertions.assertThat(save).isNotNull();
        Assertions.assertThat(save.getId()).isEqualTo(1L);
        Assertions.assertThat(save.getProblem().getId()).isEqualTo(12865L);
        Assertions.assertThat(save.getInput()).isEqualTo(new String[]{"4 7", "6 13", "4 8", "3 6", "5 12"});
        Assertions.assertThat(save.getOutput()).isEqualTo(new String[]{"14"});
    }

    @DisplayName("문제 입력 삭제")
    @Test
    public void deleteTest(){
        ProblemInput problemInput = getProblemInput();
        ProblemInput save = problemInputRepository.save(problemInput);
        problemInputRepository.delete(save);
        Assertions.assertThat(problemInputRepository.findById(1L).isEmpty());
    }


    private Problem getProblem(){
        return Problem.builder()
                .id(12865L)
                .title("평범한 배낭")
                .url("https://www.acmicpc.net/problem/12865")
                .language(Language.JAVA).build();
    }
}