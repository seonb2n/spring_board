package com.example.springboard.controller.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.springboard.domain.articles.Article;
import com.example.springboard.dto.response.CommonResponse;
import com.example.springboard.dto.response.ErrorResponse;
import com.example.springboard.util.enums.ErrorTypeWithRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class AuthIntegrationControllerTest {

    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Value("${token.no_user}")
    private String defaultToken;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }


    @DisplayName("[AuthController] default token 을 발급받으면 비회원 게시판의 조회가 가능하다.")
    @Test
    void testGetDefaultTokenAndViewNotMemberArticle() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/v1/boards/3/articles")
                .header("Authorization", defaultToken)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        String articleListResponse = mvcResult.getResponse().getContentAsString();
        CommonResponse<List<Article>> articleList = objectMapper.readValue(
            articleListResponse, new TypeReference<CommonResponse<List<Article>>>() {
            });

        assertEquals(0, articleList.getData().size());
    }

    @DisplayName("[AuthController] default token 을 발급받으면 전체 회원 게시판의 조회가 가능하다.")
    @Test
    void testGetDefaultTokenAndViewAllMemberArticle() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/v1/boards/1/articles")
                .header("Authorization", defaultToken)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        String articleListResponse = mvcResult.getResponse().getContentAsString();
        CommonResponse<List<Article>> articleList = objectMapper.readValue(
            articleListResponse, new TypeReference<CommonResponse<List<Article>>>() {
            });

        assertEquals(2, articleList.getData().size());
    }

    @DisplayName("[AuthController] default token 을 발급받으면 회원 게시판의 조회가 불가능하다.")
    @Test
    void testGetDefaultTokenAndCannotViewMemberArticle() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/v1/boards/2/articles")
                .header("Authorization", defaultToken)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        ErrorResponse errorResponse = objectMapper.readValue(response,
            new TypeReference<ErrorResponse>() {
            });
        assertEquals(ErrorTypeWithRequest.ARTICLE_LIST_VIEW_NO_AUTH.getCode(),
            errorResponse.getResponseCode());
    }
}
