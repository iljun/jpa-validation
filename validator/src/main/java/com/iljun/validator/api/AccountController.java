package com.iljun.validator.api;

import com.iljun.validator.api.request.AccountDto;
import com.iljun.validator.api.request.AccountDtoValidator;
import com.iljun.validator.domain.AccountService;
import com.iljun.validator.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.Format;
import java.util.List;
import java.util.Locale;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 15
 * Time: 오후 1:43
 */
@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountDtoValidator accountDtoValidator;

    @Autowired
    private ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource;

    @InitBinder
    private void initBinder(WebDataBinder dataBinder){
        dataBinder.setValidator(accountDtoValidator);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String signUp(@RequestBody @Valid AccountDto accountDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult);
        }
        return "SUCCESS";
    }
}
