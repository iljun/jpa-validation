package com.iljun.validator.exception;

import org.springframework.validation.BindingResult;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 15
 * Time: 오후 2:00
 */
public class BadRequestException extends RuntimeException{
    public BindingResult bindingResult;

    public BadRequestException(BindingResult bindingResult){
        super("Bad Request");
        this.bindingResult = bindingResult;
    }
}
