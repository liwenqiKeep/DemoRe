package org.lwq.jpademo;

import org.junit.jupiter.api.Test;
import org.lwq.jpademo.entity.Account;
import org.lwq.jpademo.entity.AccountSecure;
import org.lwq.jpademo.repository.AccountRepository;
import org.lwq.jpademo.repository.CompanyRepository;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaDemoApplicationTests {

    @Resource
    AccountRepository repository;

    @Resource
    CompanyRepository companyRepository;


    @Test
    void contextLoads() {
    }

    @Test
    void accountRepositoryTest() {
        doJoinAccountSecure();
//        doInsertAccount();
//        doFindAllByUsername();
//


        doDeleteAllAccount();
        companyRepository.deleteAll();

    }

    private void doJoinAccountSecure() {

        AccountSecure accountSecure = new AccountSecure();
        accountSecure.setSlot("dtsw");
        companyRepository.save(accountSecure);

        doInsertAccount();

        Optional<Account> account = repository.findById(1);
        System.out.println("=========join============" + account.get().getAccountSecure());

    }

    private void doFindAllByUsername() {
        List<Account> accounts = repository.findAllByUsernameLike("%d%");
        assert accounts != null && accounts.get(0).getUid() > 0;
    }

    private void doDeleteAllAccount() {
        repository.deleteAll();
    }

    private void doInsertAccount() {
        Account account = new Account();
        account.setUsername("Admin");
        account.setPassword("123456");
        AccountSecure secure = new AccountSecure();
        secure.setId(1);
        account.setAccountSecure(secure);
        account = repository.save(account);
        assert account.getUid() != 0;
    }


}
