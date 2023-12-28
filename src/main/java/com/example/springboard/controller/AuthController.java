package com.example.springboard.controller;

import com.example.springboard.dto.request.auth.LoginRequest;
import com.example.springboard.dto.request.auth.ValidAuthRequestDto;
import com.example.springboard.dto.response.CommonResponse;
import com.example.springboard.dto.response.auth.LoginResponseDto;
import com.example.springboard.dto.response.auth.ValidAuthResponseDto;
import com.example.springboard.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    CommonResponse<LoginResponseDto> login(@RequestBody LoginRequest request) {
        return null;
    }

    @PostMapping("/check/article")
    CommonResponse<ValidAuthResponseDto> checkArticleAuth(@RequestBody ValidAuthRequestDto dto) {
        return null;
    }

    @PostMapping("/check/comment")
    CommonResponse<ValidAuthResponseDto> checkCommentAuth(@RequestBody ValidAuthRequestDto dto) {
        return null;
    }
}
