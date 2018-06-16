package com.iljun.validator.exception;

import com.iljun.validator.api.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 15
 * Time: 오후 2:00
 */
@ControllerAdvice
@RestController
@Slf4j
public class GlobalExceptionHandler {

    @Autowired
    private ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource;

    @ExceptionHandler(BadRequestException.class)
    public List<ErrorResponse> badRequestExceptionHandler(BadRequestException e){

        List<FieldError> list = e.bindingResult.getFieldErrors();
        return list.stream()
                .map(error -> ErrorResponse
                        .builder()
                        .code(error.getCode())
                        .filed(error.getField())
                        .msg(reloadableResourceBundleMessageSource.getMessage(error.getCode(),null, Locale.getDefault()))
                        .build())
                .collect(Collectors.toList());
    }
}
