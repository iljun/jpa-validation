package com.jpa.validation.api.request;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 14
 * Time: 오후 4:43
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    @Email
    private String email;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String password;

    @Override
    public String toString(){
        return String.format("AccountDto( email = %s, firstName = %s, lastName = %s, password = %s)",this.email,this.firstName,this.lastName,this.password);
    }
}
