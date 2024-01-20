package com.example.springboard.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.springboard.domain.boards.Board;
import com.example.springboard.dto.response.CommonResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ActiveProfiles("local")
@SpringBootTest
@AutoConfigureMockMvc
class BoardControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetBoardList() throws Exception {

        // when
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/v1/boards/list")
                .contentType(MediaType.APPLICATION_JSON))
            .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        CommonResponse<List<Board>> response = objectMapper.readValue(responseContent,
            new TypeReference<CommonResponse<List<Board>>>() {
            });

        // then
        assertEquals(200, result.getResponse().getStatus());
        assertEquals(HttpStatus.OK.getReasonPhrase(), response.getMessage());
        assertEquals(3, response.getData().size());
    }
}