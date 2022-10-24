package com.example.demo.error;

import com.example.demo.error.exception.NotFoundEmployee;
import com.example.demo.error.exception.NotPermission;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandleErrorRestFull {
    @ExceptionHandler(NotFoundEmployee.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> notFoundHandle(NotFoundEmployee e){
        Map<String, String> map = new HashMap<>();
        map.put("messageerror ",e.getMessage());
        return map;
    }

    @ExceptionHandler(NotPermission.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> notFoundHandle(NotPermission e){
        Map<String, String> map = new HashMap<>();
        map.put("messageerror ",e.getMessage());
        return map;
    }
}
