package com.example.springboard.dto.response;

import java.time.LocalDateTime;

public class CommonResponse<T> {
    private LocalDateTime responseTime;
    private String message;
    private T data;

    public CommonResponse() {
    }

    private CommonResponse(String message, T data) {
        this.responseTime = LocalDateTime.now();
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResponse<T> of(String message, T data) {
        return new CommonResponse<>(message, data);
    }

    public LocalDateTime getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(LocalDateTime responseTime) {
        this.responseTime = responseTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
