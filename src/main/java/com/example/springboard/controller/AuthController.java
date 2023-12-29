package com.example.springboard.controller;

import com.example.springboard.dto.request.auth.LoginRequest;
import com.example.springboard.dto.request.auth.ValidAuthRequest;
import com.example.springboard.dto.response.CommonResponse;
import com.example.springboard.dto.response.auth.LoginResponseDto;
import com.example.springboard.dto.response.auth.ValidAuthResponseDto;
import com.example.springboard.service.AuthFacadeService;
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

    @PostMapping("/login")
    CommonResponse<LoginResponseDto> login(@RequestBody LoginRequest request) {
        return null;
    }

    @PostMapping("/check/article")
    CommonResponse<ValidAuthResponseDto> checkArticleAuth(@RequestBody ValidAuthRequest dto) {
        return null;
    }

    @PostMapping("/check/comment")
    CommonResponse<ValidAuthResponseDto> checkCommentAuth(@RequestBody ValidAuthRequest dto) {
        return null;
    }
}
