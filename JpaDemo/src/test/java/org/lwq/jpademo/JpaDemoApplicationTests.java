package org.lwq.jpademo;

import org.junit.jupiter.api.Test;
import org.lwq.jpademo.entity.Account;
import org.lwq.jpademo.entity.AccountSecure;
import org.lwq.jpademo.repository.AccountRepository;
import org.lwq.jpademo.repository.AccountSecureRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@SpringBootTest

class JpaDemoApplicationTests {

    @Resource
    AccountRepository accountRepository;

    @Resource
    AccountSecureRepository accountSecureRepository;


    @Test
    void contextLoads() {
    }

    @Test
    void accountRepositoryTest() {
//        doInsertAccount();
        doJoinAccountSecure();

        doSpecification();
//        doFindAllByUsername();
//


//        doDeleteAllAccount();
//        companyRepository.deleteAll();



    }

    private void doSpecification() {
        Specification<Account> spec = new Specification<Account>() {
            /**
             * @return Predicate:定义了查询条件
             * @param root<Users> root:根对象。封装了查询条件的对象
             * @param query<?> query:定义了一个基本的查询.一般不
            使用
             * @param criteriaBuilder cb:创建一个查询条件
             */
            @Override
            public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate pre = criteriaBuilder.equal(root.get("uid"), 1);
                return pre;
            }

        };
        Optional<Account> account = accountRepository.findOne(spec);
        System.out.println("==================Specification===========");
        System.out.println(account.get());
    }

    private void doJoinAccountSecure() {

        AccountSecure accountSecure = new AccountSecure();
        accountSecure.setSlot("dtsw");
        accountSecureRepository.save(accountSecure);

        doInsertAccount();

        Optional<Account> account = accountRepository.findById(1);
        System.out.println("=========join============" + account.get().getAccountSecure());

    }

    private void doFindAllByUsername() {
        List<Account> accounts = accountRepository.findAllByUsernameLike("%d%");
        assert accounts != null && accounts.get(0).getUid() > 0;
    }

    private void doDeleteAllAccount() {
        accountRepository.deleteAll();
    }

    private void doInsertAccount() {
        Account account = new Account();
        account.setUsername("Admin");
        account.setPassword("123456");
        AccountSecure secure = new AccountSecure();
        System.out.println(account.getUid());
        secure.setId(1);
        account.setAccountSecure(secure);
        account = accountRepository.save(account);
        assert account.getUid() != 0;
    }


}
