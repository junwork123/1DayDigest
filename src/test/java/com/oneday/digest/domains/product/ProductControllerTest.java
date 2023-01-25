package com.oneday.digest.domains.product;

import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @DisplayName("DTO Validation 실패 테스트")
    @Test
    void addProduct_Fail_with_Validation() throws Exception {

        // given
        ProductController.ProductRequestDto requestDto = new ProductController.ProductRequestDto("", -1, 10);

        // when
        final ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post("/product")
                        .content(gson.toJson(requestDto))
                        .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions.andExpect(status().isNotAcceptable());
    }
}