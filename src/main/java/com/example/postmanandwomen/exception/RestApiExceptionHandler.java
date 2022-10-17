package com.example.postmanandwomen.exception;

import com.example.postmanandwomen.dto.ResponseDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestApiExceptionHandler {
    @ExceptionHandler(value = { RequestException.class })
    public ResponseDto<Object> handleApiRequestException(RequestException e) {

        return ResponseDto.fail(
                e.getHttpStatus(),
                e.getMessage()
        );
    }
}
