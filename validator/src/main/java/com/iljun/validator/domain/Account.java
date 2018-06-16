package com.iljun.validator.domain;

import com.iljun.validator.api.request.AccountDto;
import lombok.*;

import javax.persistence.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 15
 * Time: 오후 1:42
 */
@Entity
@Table(name ="account")
@Getter
@Builder
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "password")
    private String password;

    public static Account of(AccountDto accountDto){
        return new Account().builder()
                .email(accountDto.getEmail())
                .lastName(accountDto.getLastName())
                .firstName(accountDto.getFirstName())
                .password(accountDto.getPassword())
                .build();
    }
}
