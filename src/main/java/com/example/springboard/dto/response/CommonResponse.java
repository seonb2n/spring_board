package com.example.springboard.dto.response;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

public class CommonResponse<T> {
    private LocalDateTime responseTime;
    private int responseCode;
    private T data;

    protected CommonResponse() {
    }

    protected CommonResponse(int responseCode, T data) {
        this.responseTime = LocalDateTime.now();
        this.responseCode = responseCode;
        this.data = data;
    }

    public static <T> CommonResponse<T> of(int responseCode, T data) {
        return new CommonResponse<>(responseCode, data);
    }

    public static <T> CommonResponse<T> of(HttpStatus httpStatus, T data) {
        return new CommonResponse<>(httpStatus.value(), data);
    }

    public LocalDateTime getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(LocalDateTime responseTime) {
        this.responseTime = responseTime;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
