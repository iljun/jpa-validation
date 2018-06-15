package com.jpa.validation.domain;

import com.jpa.validation.api.request.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 14
 * Time: 오후 4:46
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void signUp(AccountDto accountDto){
        accountRepository.save(Account.of(accountDto));
    }

}
