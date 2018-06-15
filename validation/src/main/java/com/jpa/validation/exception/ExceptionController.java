package com.jpa.validation.exception;

import com.jpa.validation.api.response.ErrorResponse;
import com.jpa.validation.api.response.FiledError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 14
 * Time: 오후 4:46
 */
@ControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public void defaultExceptionHandler(Exception e){
        log.error(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> validationExceptionHandler(MethodArgumentNotValidException e){
        log.error(e.getMessage());

        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> errorList = bindingResult.getFieldErrors();

        return new ResponseEntity<ErrorResponse>(
                ErrorResponse
                .builder()
                    .msg("입력값이 올바르지 않습니다.")
                    .status(HttpStatus.BAD_REQUEST.value())
                    .filedError(
                        errorList.stream()
                            .map(error -> FiledError
                                    .builder()
                                    .filed(error.getField())
                                    .reason(error.getDefaultMessage())
                                    .value((String)error.getRejectedValue())
                                    .build())
                                .collect(Collectors.toList())
                    )
                .build()
                ,HttpStatus.BAD_REQUEST
        );
    }
}
