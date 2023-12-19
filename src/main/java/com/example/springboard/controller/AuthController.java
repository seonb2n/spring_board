package com.example.springboard.controller;

import com.example.springboard.dto.request.auth.LoginRequest;
import com.example.springboard.dto.response.CommonResponse;
import com.example.springboard.dto.response.auth.LoginResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @PostMapping("/login")
    CommonResponse<LoginResponseDto> login(LoginRequest request) {
        return null;
    }

}
