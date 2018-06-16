package com.iljun.validator.api.request;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 15
 * Time: 오후 1:54
 */
@Component
public class AccountDtoValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return AccountDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AccountDto accountDto = (AccountDto)o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email", "email_not_empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastName", "lastName_not_empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName", "firstName_not_empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "password_not_empty");

        if(accountDto.getPassword().length()<4 || accountDto.getPassword().length()>8)
            errors.rejectValue("password", "password_length");
    }
}
