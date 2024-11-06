package com.example.springbootfirstdemo.exception;

import com.example.springbootfirstdemo.pojo.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    @ExceptionHandler({Exception.class}) // 代表什么异常的统一处理
    public ResponseMessage handleException(Exception e, HttpServletRequest request, HttpServletResponse response){

        Logger logger = LoggerFactory.getLogger(GlobalExceptionHandlerAdvice.class);

        // 记录日志
        logger.error("统一异常",e);
        return new ResponseMessage(500,"error",null);
    }
}
