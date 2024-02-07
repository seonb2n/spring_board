package com.example.springboard.controller.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.springboard.domain.articles.Article;
import com.example.springboard.dto.request.article.ArticleCreateRequest;
import com.example.springboard.dto.request.article.ArticleModifyRequest;
import com.example.springboard.dto.response.CommonResponse;
import com.example.springboard.dto.response.ErrorResponse;
import com.example.springboard.util.enums.ErrorTypeWithRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
public class ArticleControllerIntegrationTest {

    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Value("${token.user}")
    private String memberToken;
    @Value("${token.no_user}")
    private String notMemberToken;
    @Value("${token.default}")
    private String defaultToken;


    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @DisplayName("[ArticleController] 회원인 경우, 전체 게시판에 글을 작성할 수 있다.")
    @Test
    void testCreateArticleByMember() throws Exception {
        ArticleCreateRequest request = new ArticleCreateRequest("new article",
            "new article content", null, null);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/v1/articles/1/create")
                .header("Authorization", memberToken)
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

    @DisplayName("[ArticleController] 비회원인 경우, 전체 게시판에 글을 작성할 수 있다.")
    @Test
    void testCreateArticleByNotMember() throws Exception {
        ArticleCreateRequest request = new ArticleCreateRequest("new article",
            "new article content", "new no member user", "1234");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/v1/articles/1/create")
                .header("Authorization", defaultToken)
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

    @DisplayName("[ArticleController] 회원인 경우, 회원 게시판에 글을 작성할 수 있다.")
    @Test
    void testCreateArticleByMemberAtMemberBoard() throws Exception {
        ArticleCreateRequest request = new ArticleCreateRequest("new article",
            "new article content", null, null);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/v1/articles/2/create")
                .header("Authorization", memberToken)
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

    @DisplayName("[ArticleController] 비회원인 경우, 회원 게시판에 글을 작성할 수 없다.")
    @Test
    void testCreateArticleByNotMemberWriteMemberBoard() throws Exception {
        ArticleCreateRequest request = new ArticleCreateRequest("new article",
            "new article content", "new no member user", "1234");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/v1/articles/2/create")
                .header("Authorization", defaultToken)
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        String articleResponse = mvcResult.getResponse().getContentAsString();
        CommonResponse<Article> articleCommonResponse = objectMapper.readValue(articleResponse,
            new TypeReference<CommonResponse<Article>>() {
            });

        assertNull(articleCommonResponse.getData());
    }

    @DisplayName("[ArticleController] 회원인 경우, 비회원 게시판에 글을 작성할 수 없다.")
    @Test
    void testCreateArticleByMemberWriteNoMemberBoard() throws Exception {
        ArticleCreateRequest request = new ArticleCreateRequest("new article",
            "new article content", "new no member user", "1234");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/v1/articles/3/create")
                .header("Authorization", memberToken)
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        String articleResponse = mvcResult.getResponse().getContentAsString();
        CommonResponse<Article> articleCommonResponse = objectMapper.readValue(articleResponse,
            new TypeReference<CommonResponse<Article>>() {
            });

        assertNull(articleCommonResponse.getData());
    }

    @DisplayName("[ArticleController] 회원인 경우, 내가 작성한 게시글을 수정할 수 있다.")
    @Test
    public void testMemberCanModifyArticle() throws Exception {
        ArticleModifyRequest request = new ArticleModifyRequest("new article2",
            "new article content2", null, null);

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.patch("/v1/articles/2/modify/3")
                    .header("Authorization", memberToken)
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
            ).andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        String articleResponse = mvcResult.getResponse().getContentAsString();
        CommonResponse<Article> articleCommonResponse = objectMapper.readValue(articleResponse,
            new TypeReference<CommonResponse<Article>>() {
            });

        assertNotNull(articleCommonResponse.getData());
        assertTrue(articleCommonResponse.getData().getContent().equals("new article content2"));
        assertTrue(articleCommonResponse.getData().getTitle().equals("new article2"));
    }

    @DisplayName("[ArticleController] 회원인 경우, 내가 작성하지 않은 게시글은 수정할 수 없다.")
    @Test
    public void testMemberCannotModifyArticle() throws Exception {
        ArticleModifyRequest request = new ArticleModifyRequest("new article2",
            "new article content2", null, null);

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.patch("/v1/articles/1/modify/1")
                    .header("Authorization", memberToken)
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
            ).andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        String articleResponse = mvcResult.getResponse().getContentAsString();
        CommonResponse<Article> articleCommonResponse = objectMapper.readValue(articleResponse,
            new TypeReference<CommonResponse<Article>>() {
            });

        assertNull(articleCommonResponse.getData());
    }

    @DisplayName("[ArticleController] 비회원인 경우, 내가 작성한 게시글은 수정할 수 있다.")
    @Test
    public void testNoMemberCanModifyArticle() throws Exception {
        ArticleModifyRequest request = new ArticleModifyRequest("new article2",
            "new article content2", null, null);

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.patch("/v1/articles/1/modify/1")
                    .header("Authorization", notMemberToken)
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
            ).andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        String articleResponse = mvcResult.getResponse().getContentAsString();
        CommonResponse<Article> articleCommonResponse = objectMapper.readValue(articleResponse,
            new TypeReference<CommonResponse<Article>>() {
            });

        assertNotNull(articleCommonResponse.getData());
        assertTrue(articleCommonResponse.getData().getContent().equals("new article content2"));
        assertTrue(articleCommonResponse.getData().getTitle().equals("new article2"));
    }

    @DisplayName("[ArticleController] 비회원인 경우, 내가 작성하지 않은 게시글은 수정할 수 없다.")
    @Test
    public void testNoMemberCannotModifyArticle() throws Exception {
        ArticleModifyRequest request = new ArticleModifyRequest("new article2",
            "new article content2", null, null);

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.patch("/v1/articles/2/modify/3")
                    .header("Authorization", notMemberToken)
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
            ).andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        String articleResponse = mvcResult.getResponse().getContentAsString();
        CommonResponse<Article> articleCommonResponse = objectMapper.readValue(articleResponse,
            new TypeReference<CommonResponse<Article>>() {
            });

        assertNull(articleCommonResponse.getData());
    }

    @DisplayName("[ArticleController] 회원인 경우, 회원 전용 게시글을 볼 수 있다.")
    @Test
    public void testMemberCanViewArticleAtMemberBoard() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/v1/articles/2/3")
                    .header("Authorization", memberToken)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
            ).andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        String articleResponse = mvcResult.getResponse().getContentAsString();
        CommonResponse<Article> articleCommonResponse = objectMapper.readValue(articleResponse,
            new TypeReference<CommonResponse<Article>>() {
            });

        assertNotNull(articleCommonResponse.getData());
    }

    @DisplayName("[ArticleController] 회원인 경우, 비회원 전용 게시글을 볼 수 없다.")
    @Test
    public void testMemberCannotViewArticleAtNotMemberBoard() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/v1/articles/3/1")
                    .header("Authorization", memberToken)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
            ).andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        String articleResponse = mvcResult.getResponse().getContentAsString();
        CommonResponse<ErrorResponse> articleCommonResponse = objectMapper.readValue(
            articleResponse,
            new TypeReference<CommonResponse<ErrorResponse>>() {
            });

        assertEquals(ErrorTypeWithRequest.ARTICLE_VIEW_NO_AUTH.getCode(),
            articleCommonResponse.getData().getStatusCode());
    }

    @DisplayName("[ArticleController] 비회원인 경우, 비회원 전용 게시글을 볼 수 있다.")
    @Test
    public void testNotMemberCanViewArticleAtNotMemberBoard() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/v1/articles/3/1")
                    .header("Authorization", notMemberToken)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
            ).andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        String articleResponse = mvcResult.getResponse().getContentAsString();
        CommonResponse<Article> articleCommonResponse = objectMapper.readValue(articleResponse,
            new TypeReference<CommonResponse<Article>>() {
            });

        assertNotNull(articleCommonResponse.getData());
    }

    @DisplayName("[ArticleController] 비회원인 경우, 회원 전용 게시글을 볼 수 없다.")
    @Test
    public void testNotMemberCannotViewArticleAtMemberBoard() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/v1/articles/2/1")
                    .header("Authorization", notMemberToken)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
            ).andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        String articleResponse = mvcResult.getResponse().getContentAsString();
        CommonResponse<ErrorResponse> articleCommonResponse = objectMapper.readValue(
            articleResponse,
            new TypeReference<CommonResponse<ErrorResponse>>() {
            });

        assertEquals(ErrorTypeWithRequest.ARTICLE_VIEW_NO_AUTH.getCode(),
            articleCommonResponse.getData().getStatusCode());
    }
}
