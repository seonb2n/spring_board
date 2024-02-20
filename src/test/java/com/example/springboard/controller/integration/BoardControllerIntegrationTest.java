package com.example.springboard.controller.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.springboard.domain.articles.Article;
import com.example.springboard.domain.boards.Board;
import com.example.springboard.dto.request.auth.LoginRequest;
import com.example.springboard.dto.response.CommonResponse;
import com.example.springboard.dto.response.auth.LoginResponseDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class BoardControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    /**
     * 모든 사용자가 게시판 목록을 조회할 수 있는지 테스트
     *
     * @throws Exception
     */
    @Test
    void testGetBoardList() throws Exception {

        // when
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/v1/boards/list/1")
                .contentType(MediaType.APPLICATION_JSON))
            .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        CommonResponse<List<Board>> response = objectMapper.readValue(responseContent,
            new TypeReference<CommonResponse<List<Board>>>() {
            });

        // then
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(3, response.getData().size());
    }

    /**
     * Member 인 경우, Member Only 게시판의 게시물을 조회할 수 있는지 테스트
     *
     * @throws Exception
     */
    @Test
    void testGetMemberOnlyArticlesByBoardId() throws Exception {
        // User Token 인 경우
        LoginRequest request = new LoginRequest("test01_id", "test01_password");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/v1/auth/login")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        String loginResponseContent = result.getResponse().getContentAsString();
        CommonResponse<LoginResponseDto> loginResponse = objectMapper.readValue(
            loginResponseContent,
            new TypeReference<CommonResponse<LoginResponseDto>>() {
            });
        assertNotNull(loginResponse.getData().getToken());
        String userToken = loginResponse.getData().getToken();

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/v1/boards/{board_id}/articles", 2)
                    .header(HttpHeaders.AUTHORIZATION, userToken)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        assertEquals(200, mvcResult.getResponse().getStatus());
        String boardListResponseContent = mvcResult.getResponse().getContentAsString();
        CommonResponse<List<Article>> boardListResponse = objectMapper.readValue(
            boardListResponseContent,
            new TypeReference<CommonResponse<List<Article>>>() {
            });
        assertNotNull(boardListResponse.getData().size());

    }
}