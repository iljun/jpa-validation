package com.jpa.validation.api;

import com.jpa.validation.api.request.AccountDto;
import com.jpa.validation.domain.Account;
import com.jpa.validation.domain.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 14
 * Time: 오후 4:42
 */
@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "" , method = RequestMethod.POST)
    public void signUp(@RequestBody @Valid AccountDto accountDto){
        log.info(accountDto.toString());
        accountService.signUp(accountDto);
    }


}
