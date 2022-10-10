package com.oneday.digest.baekjoon;

import com.google.gson.Gson;
import com.oneday.digest.algorithm.ProblemController;
import com.oneday.digest.algorithm.ProblemSolvingService;
import com.oneday.digest.entity.metaInfo.Language;
import com.oneday.digest.entity.web.ProblemRequest;
import com.oneday.digest.entity.web.ProblemResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class baekjoonServiceTest {
    @InjectMocks
    private ProblemController problemController;
    @Mock
    private ProblemSolvingService problemSolvingService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(problemController).build();
    }

    @Test
    void solve() throws Exception {
        ProblemRequest request = getProblemRequest();
        ProblemResponse response = getProblemResponse();

        //when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post("/baekjoon/12865")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(request)))
        //then
                        .andExpect(status().isOk())
        //              .andExpect(jsonPath("answer").value("14"))
                        .andDo(print());

    }

    private static ProblemResponse getProblemResponse() {
        List<String[]> outputs = new ArrayList<>();
        outputs.add(new String[]{"14"});

        return ProblemResponse.builder()
                .results(outputs).build();
    }

    public ProblemRequest getProblemRequest(){
        List<String[]> inputs = new ArrayList<>();
        inputs.add(new String[]{"4 7", "6 13", "4 8", "3 6", "5 12"});

        List<String[]> outputs = new ArrayList<>();
        outputs.add(new String[]{"14"});

        return ProblemRequest.builder()
                .id(12865L)
                .title("평범한 배낭")
                .url("https://www.acmicpc.net/problem/12865")
                .language(Language.JAVA)
                .inputs(inputs)
                .outputs(outputs)
                .build();
    }
}