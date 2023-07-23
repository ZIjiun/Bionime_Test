package com.kent.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public ReturnFormat doException(Exception ex){
        ex.printStackTrace();
        return new ReturnFormat("伺服器故障，請稍後再試");
    }
}

