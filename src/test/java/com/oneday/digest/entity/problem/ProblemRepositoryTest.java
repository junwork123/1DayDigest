package com.oneday.digest.entity.problem;

import com.oneday.digest.entity.metaInfo.Language;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.oneday.digest.TestUtils.getProblem;

@DataJpaTest
class ProblemRepositoryTest {
    @Autowired
    private ProblemRepository problemRepository;

    @DisplayName("문제 저장")
    @Test
    public void saveTest(){
        Problem problem = getProblem();
        Problem save = problemRepository.save(problem);

        Assertions.assertThat(save).isNotNull();
        Assertions.assertThat(save.getId()).isEqualTo(12865L);
        Assertions.assertThat(save.getTitle()).isEqualTo("평범한 배낭");
        Assertions.assertThat(save.getUrl()).isEqualTo("https://www.acmicpc.net/problem/12865");
        Assertions.assertThat(save.getLanguage()).isEqualTo(Language.JAVA);
    }

    @DisplayName("문제 삭제")
    @Test
    public void deleteTest(){
        Problem problem = getProblem();
        Problem save = problemRepository.save(problem);
        problemRepository.delete(save);
        Assertions.assertThat(problemRepository.findById(12865L).isEmpty());
    }

}