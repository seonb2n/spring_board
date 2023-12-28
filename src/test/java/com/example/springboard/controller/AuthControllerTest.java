package com.example.springboard.controller;

import com.example.springboard.service.AuthService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(AuthController.class)
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    @DisplayName("[AuthController] 회원이 정확한 ID 와 Password 를 보낼 시, token 을 응답한다.")
    @Test
    public void givenCorrectIdAndPassword_whenRequestAuth_thenReturnToken() throws Exception {
        //given

        //when

        //then
    }

    @DisplayName("[AuthController] 회원이 정확하지 않은 ID 와 Password 를 보낼 시, 401 로 응답한다.")
    @Test
    public void givenWrongIdOrPassword_whenRequestAuth_thenReturn401() throws Exception {
        //given

        //when

        //then
    }

    @DisplayName("[AuthController] 비회원이 자신이 작성한 게시글에 권한을 요구할 시, 토큰을 발급한다.")
    @Test
    public void givenNicknameAndPassword_whenRequestAuthForArticle_thenReturnToken()
        throws Exception {
        //given

        //when

        //then
    }

    @DisplayName("[AuthController] 비회원이 자신이 작성하지 않은 게시글에 권한을 요구할 시, 401로 응답한다.")
    @Test
    public void givenWrongNicknameOrPassword_whenRequestAuthForArticle_thenReturn401()
        throws Exception {
        //given

        //when

        //then
    }

    @DisplayName("[AuthController] 비회원이 자신이 작성한 댓글에 권한을 요구할 시, 토큰을 발급한다.")
    @Test
    public void givenNicknameAndPassword_whenRequestAuthForComment_thenReturnToken()
        throws Exception {
        //given

        //when

        //then
    }

    @DisplayName("[AuthController] 비회원이 자신이 작성하지 않은 댓글에 권한을 요구할 시, 401로 응답한다.")
    @Test
    public void givenWrongNicknameAndPassword_whenRequestAuthForComment_thenReturn401()
        throws Exception {
        //given

        //when

        //then
    }
}