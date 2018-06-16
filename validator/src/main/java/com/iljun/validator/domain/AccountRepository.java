package com.iljun.validator.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 15
 * Time: 오후 1:42
 */
@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{
}
