package com.example.springboard.dto.response;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

public class CommonResponse<T> {

    private LocalDateTime timestamp;
    private int status;
    private T data;

    protected CommonResponse() {
    }

    protected CommonResponse(int responseCode, T data) {
        this.timestamp = LocalDateTime.now();
        this.status = responseCode;
        this.data = data;
    }

    public static <T> CommonResponse<T> of(int responseCode, T data) {
        return new CommonResponse<>(responseCode, data);
    }

    public static <T> CommonResponse<T> of(HttpStatus httpStatus, T data) {
        return new CommonResponse<>(httpStatus.value(), data);
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
