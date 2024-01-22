package com.example.springboard.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.springboard.domain.articles.Article;
import com.example.springboard.dto.request.article.ArticleCreateRequest;
import com.example.springboard.dto.response.CommonResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
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

@ActiveProfiles("local")
@SpringBootTest
@AutoConfigureMockMvc
public class ArticleControllerIntegrationTest {

    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @Value("${token.user}")
    private String token;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    /**
     * 권한이 적절한 경우, 회원 게시판에 글을 작성할 수 있다.
     *
     * @throws Exception
     */
    @Test
    void testCreateArticleByMember() throws Exception {
        ArticleCreateRequest request = new ArticleCreateRequest("new article",
            "new article content");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/v1/articles/create/1")
                .header("Authorization", token)
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        String articleResponse = mvcResult.getResponse().getContentAsString();
        CommonResponse<Article> articleCommonResponse = objectMapper.readValue(articleResponse,
            new TypeReference<CommonResponse<Article>>() {
            });
        assertNotNull(articleCommonResponse.getData());
        assertNotNull(articleCommonResponse.getData().getId());
    }

    /**
     * 권한이 없는 경우 회원 게시판에 글을 쓸 수 없다.
     *
     * @throws Exception
     */
    @Test
    void testCreateArticleByNotMember() throws Exception {
        ArticleCreateRequest request = new ArticleCreateRequest("new article",
            "new article content");

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/articles/create/1")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isUnauthorized())
            .andReturn();
    }

}
