package com.example.springboard.controller.slice;

import static org.mockito.BDDMockito.given;

import com.example.springboard.common.exception.GlobalException;
import com.example.springboard.controller.AuthController;
import com.example.springboard.dto.request.auth.LoginRequest;
import com.example.springboard.dto.request.auth.ValidAuthRequest;
import com.example.springboard.service.AuthFacadeService;
import com.example.springboard.util.enums.ErrorTypeWithRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(AuthController.class)
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthFacadeService authFacadeService;

    @InjectMocks
    private AuthController authController;

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("[AuthController] 게시판 목록에 들어온 회원은 DefaultToken 을 발급받는다.")
    @Test
    public void givenCreateDefaultToken_whenRequestDefaultToken_thenReturnDefaultToken()
        throws Exception {
        //given
        String token = "token_1234";

        given(authFacadeService.getDefaultToken()).willReturn(token);

        //when & then
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders
                    .get("/v1/auth/default")
            )
            .andExpect(MockMvcResultMatchers.status().isOk());

        resultActions.andExpect(
            MockMvcResultMatchers.jsonPath("$.data.token", Matchers.notNullValue()));
    }

    @DisplayName("[AuthController] 회원이 정확한 ID 와 Password 를 보낼 시, token 을 응답한다.")
    @Test
    public void givenCorrectIdAndPassword_whenRequestAuth_thenReturnToken() throws Exception {
        //given
        String userId = "user_id";
        String userPassword = "user_password";
        String token = "token_1234";
        LoginRequest request = new LoginRequest(userId, userPassword);
        given(authFacadeService.authToRegisteredUser(userId, userPassword)).willReturn(token);

        //when & then
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders
                    .post("/v1/auth/login")
                    .contentType("application/json")
                    .content(asJsonString(request)))
            .andExpect(MockMvcResultMatchers.status().isOk());

        resultActions.andExpect(
            MockMvcResultMatchers.jsonPath("$.data.token", Matchers.notNullValue()));
    }

    @DisplayName("[AuthController] 회원이 정확하지 않은 ID 와 Password 를 보낼 시, 400_001 로 응답한다.")
    @Test
    public void givenWrongIdOrPassword_whenRequestAuth_thenReturn401() throws Exception {
        //given
        String userId = "user_id";
        String userPassword = "user_password";
        LoginRequest request = new LoginRequest(userId, userPassword);
        given(authFacadeService.authToRegisteredUser(userId, userPassword)).willThrow(
            new GlobalException(Map.of(), ErrorTypeWithRequest.LOGIN_ID_WRONG));

        //when & then
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders
                    .post("/v1/auth/login")
                    .contentType("application/json")
                    .content(asJsonString(request)))
            .andExpect(MockMvcResultMatchers.status().isOk());

        resultActions.andExpect(
            MockMvcResultMatchers.jsonPath("$.status")
                .value(ErrorTypeWithRequest.LOGIN_ID_WRONG.getCode()));
    }

    @DisplayName("[AuthController] 비회원이 자신이 작성한 게시글에 권한을 요구할 시, 토큰을 발급한다.")
    @Test
    public void givenNicknameAndPassword_whenRequestAuthForArticle_thenReturnToken()
        throws Exception {
        //given
        String nickname = "abcd";
        String password = "1234";
        int targetId = 1;
        String token = "token_1234";
        ValidAuthRequest request = new ValidAuthRequest(targetId, nickname, password);
        given(authFacadeService.authToUnregisteredUserForArticle(targetId, nickname,
            password)).willReturn(token);

        //when & then
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders
                    .post("/v1/auth/check/article")
                    .contentType("application/json")
                    .content(asJsonString(request)))
            .andExpect(MockMvcResultMatchers.status().isOk());

        resultActions.andExpect(
            MockMvcResultMatchers.jsonPath("$.data.token", Matchers.notNullValue()));
    }

    @DisplayName("[AuthController] 비회원이 자신이 작성하지 않은 게시글에 권한을 요구할 시, 400_020 코드로 응답한다.")
    @Test
    public void givenWrongNicknameOrPassword_whenRequestAuthForArticle_thenReturn401()
        throws Exception {
        //given
        String nickname = "abcd";
        String password = "1234";
        int targetId = 1;
        ValidAuthRequest request = new ValidAuthRequest(targetId, nickname, password);
        given(authFacadeService.authToUnregisteredUserForArticle(targetId, nickname,
            password)).willThrow(
            new GlobalException(Map.of(), ErrorTypeWithRequest.ARTICLE_MODIFY_NO_AUTH));

        //when & then
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders
                    .post("/v1/auth/check/article")
                    .contentType("application/json")
                    .content(asJsonString(request)))
            .andExpect(MockMvcResultMatchers.status().isOk());

        resultActions.andExpect(
            MockMvcResultMatchers.jsonPath("$.status")
                .value(ErrorTypeWithRequest.ARTICLE_MODIFY_NO_AUTH.getCode()));
    }

    @DisplayName("[AuthController] 비회원이 자신이 작성한 댓글에 권한을 요구할 시, 토큰을 발급한다.")
    @Test
    public void givenNicknameAndPassword_whenRequestAuthForComment_thenReturnToken()
        throws Exception {
        //given
        String nickname = "abcd";
        String password = "1234";
        int targetId = 1;
        String token = "token_1234";
        ValidAuthRequest request = new ValidAuthRequest(targetId, nickname, password);
        given(authFacadeService.authToUnregisteredUserForComment(targetId, nickname,
            password)).willReturn(token);

        //when & then
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders
                    .post("/v1/auth/check/comment")
                    .contentType("application/json")
                    .content(asJsonString(request)))
            .andExpect(MockMvcResultMatchers.status().isOk());

        resultActions.andExpect(
            MockMvcResultMatchers.jsonPath("$.data.token", Matchers.notNullValue()));
    }

    @DisplayName("[AuthController] 비회원이 자신이 작성하지 않은 댓글에 권한을 요구할 시, 400_024로 응답한다.")
    @Test
    public void givenWrongNicknameAndPassword_whenRequestAuthForComment_thenReturn401()
        throws Exception {
        //given
        String nickname = "abcd";
        String password = "1234";
        int targetId = 1;
        ValidAuthRequest request = new ValidAuthRequest(targetId, nickname, password);
        given(authFacadeService.authToUnregisteredUserForComment(targetId, nickname,
            password)).willThrow(
            new GlobalException(Map.of(), ErrorTypeWithRequest.COMMENT_MODIFY_NO_AUTH));

        //when & then
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders
                    .post("/v1/auth/check/comment")
                    .contentType("application/json")
                    .content(asJsonString(request)))
            .andExpect(MockMvcResultMatchers.status().isOk());

        resultActions.andExpect(
            MockMvcResultMatchers.jsonPath("$.status")
                .value(ErrorTypeWithRequest.COMMENT_MODIFY_NO_AUTH.getCode()));
    }
}