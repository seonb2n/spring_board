package com.example.springboard.controller;

import com.example.springboard.dto.request.auth.LoginRequest;
import com.example.springboard.dto.request.auth.ValidAuthRequest;
import com.example.springboard.dto.response.CommonResponse;
import com.example.springboard.dto.response.auth.LoginResponseDto;
import com.example.springboard.dto.response.auth.ValidAuthResponseDto;
import com.example.springboard.service.AuthFacadeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthFacadeService authFacadeService;

    public AuthController(AuthFacadeService authFacadeService) {
        this.authFacadeService = authFacadeService;
    }

    /**
     * 회원이 로그인 시도 시, 적합한 토큰을 발급한다.
     *
     * @param request
     * @return
     */
    @PostMapping("/login")
    CommonResponse<LoginResponseDto> login(@RequestBody LoginRequest request) {
        String token = authFacadeService.authToRegisteredUser(request.getUserId(),
            request.getPassword());
        LoginResponseDto responseDto = LoginResponseDto.of(token);
        return CommonResponse.of(HttpStatus.ACCEPTED.getReasonPhrase(), responseDto);
    }

    /**
     * 비회원이 게시글에 대한 권한을 요청 시, 적합한 토큰을 발급한다.
     * @param dto
     * @return
     */
    @PostMapping("/check/article")
    CommonResponse<ValidAuthResponseDto> checkArticleAuth(@RequestBody ValidAuthRequest dto) {
        String token = authFacadeService.authToUnregisteredUserForArticle(dto.getTargetId(),
            dto.getNickname(),
            dto.getPassword());
        ValidAuthResponseDto responseDto = ValidAuthResponseDto.of(token);
        return CommonResponse.of(HttpStatus.OK.getReasonPhrase(), responseDto);
    }

    /**
     * 비회원이 댓글에 대한 권한을 요청 시, 적합한 토큰을 발급한다.
     * @param dto
     * @return
     */
    @PostMapping("/check/comment")
    CommonResponse<ValidAuthResponseDto> checkCommentAuth(@RequestBody ValidAuthRequest dto) {
        String token = authFacadeService.authToUnregisteredUserForComment(dto.getTargetId(),
            dto.getNickname(), dto.getPassword());
        ValidAuthResponseDto responseDto = ValidAuthResponseDto.of(token);
        return CommonResponse.of(HttpStatus.OK.getReasonPhrase(), responseDto);
    }
}
