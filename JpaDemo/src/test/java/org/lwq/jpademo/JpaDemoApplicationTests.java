package org.lwq.jpademo;

import org.lwq.jpademo.entity.Account;
import org.lwq.jpademo.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class JpaDemoApplicationTests {

    @Resource
    AccountRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void accountRepositoryTest() {
        doInsertAccount();

        doFindAllByUsername();

        doDeleteAllAccount();
    }

    private void doFindAllByUsername() {
        List<Account> accounts = repository.findAllByUsernameLike("%d%");
       assert  accounts!= null && accounts.get(0).getUid() > 0;
    }

    private void doDeleteAllAccount() {
         repository.deleteAll();
    }

    private void doInsertAccount() {
        Account account = new Account();
        account.setUsername("Admin");
        account.setPassword("123456");
        account = repository.save(account);
        assert account.getUid() != 0;
    }


}
