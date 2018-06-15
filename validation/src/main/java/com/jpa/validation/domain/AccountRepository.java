package com.jpa.validation.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 14
 * Time: 오후 4:46
 */
@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{
}
