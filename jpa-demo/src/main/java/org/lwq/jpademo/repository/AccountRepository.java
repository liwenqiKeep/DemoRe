package org.lwq.jpademo.repository;

import org.lwq.jpademo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liwenqi
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> , JpaSpecificationExecutor<Account> {

    /**
     * findAllByUsernameLike
     * @param str str
     * @return Account
     */
    List<Account> findAllByUsernameLike(String str);

}
