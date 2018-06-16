package com.iljun.validator.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 15
 * Time: 오후 1:43
 */
@Getter
@Setter
public class AccountDto {

    private String email;

    private String firstName;

    private String lastName;

    private String password;

    @Override
    public String toString(){
        return String.format("AccountDto( email = %s, firstName = %s, lastName = %s, password = %s)",this.email,this.firstName,this.lastName,this.password);
    }
}
