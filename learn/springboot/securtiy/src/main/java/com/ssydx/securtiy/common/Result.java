package com.ssydx.securtiy.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;
    
    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
