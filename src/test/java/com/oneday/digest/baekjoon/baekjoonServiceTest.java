package com.oneday.digest.baekjoon;

import com.google.gson.Gson;
import com.oneday.digest.entity.problemInput.ProblemInput;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.oneday.digest.TestUtils.getProblemInput;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class baekjoonServiceTest {
    @InjectMocks
    private BaekjoonController baekjoonController;
    @Mock
    private BaekjoonService baekjoonService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(baekjoonController).build();
    }

    @Test
    void solve_12865() throws Exception {
        ProblemRequest request = getProblemRequest();
        ProblemResponse response = getProblemResponse();

        //when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post("/baekjoon/12865")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(request)))
        //then
                        .andExpect(status().isOk())
                        .andExpect(content().string("14"))
        //              .andExpect(jsonPath("answer").value("14"))
                        .andDo(print());

    }

    private static ProblemResponse getProblemResponse() {
        return ProblemResponse.builder()
                .output(new String[]{"14"}).build();
    }

    public ProblemRequest getProblemRequest(){
        return ProblemRequest.of(getProblemInput());
    }
}