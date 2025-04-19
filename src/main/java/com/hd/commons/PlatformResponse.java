package com.hd.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatformResponse<T> implements Serializable {

    private String code;

    private String message;

    private boolean success;

    private T data;

    public static <T> PlatformResponse<T> success() {
        return success(ResponseCode.SYS_SUCCESS.getCode(), ResponseCode.SYS_SUCCESS.getMessage(), null);
    }

    public static <T> PlatformResponse<T> success(T data) {
        return success(ResponseCode.SYS_SUCCESS.getCode(), ResponseCode.SYS_SUCCESS.getMessage(), data);
    }

    public static <T> PlatformResponse<T> success(String code, String message) {
        return success(code, message, null);
    }

    public static <T> PlatformResponse<T> success(String code, String message, T data) {
        return new PlatformResponse<T>(code, message, true, data);
    }

    public static <T> PlatformResponse<T> failure(T data) {
        return failure(ResponseCode.SYS_FAILURE.getCode(), data);
    }

    public static <T> PlatformResponse<T> failure(String code, String message) {
        return failure(ResponseCode.SYS_FAILURE.getCode(), message, null);
    }

    public static <T> PlatformResponse<T> failure(String code, T data) {
        return failure(code, null, data);
    }

    public static <T> PlatformResponse<T> failure(String code, String message, T data) {
        return new PlatformResponse<T>(code, message, false, data);
    }

    public static <T> PlatformResponse<T> error() {
        return new PlatformResponse<T>(ResponseCode.SYSTEM_EXCEPTION.getCode(), ResponseCode.SYSTEM_EXCEPTION.getMessage(), false, null);
    }

}
