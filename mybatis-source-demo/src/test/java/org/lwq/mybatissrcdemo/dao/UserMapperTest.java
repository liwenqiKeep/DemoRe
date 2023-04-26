package org.lwq.mybatissrcdemo.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lwq.mybatissrcdemo.entity.User;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.Reader;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-config-db.xml")
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;


    @Test
    public void testQueryUserInfoById() {
        testByMybatis();


//        testBySpringMybatis();
    }

    private void testBySpringMybatis() {
        User user = userMapper.queryUserInfoById(1L);
        System.out.println(user);
        assert user.getUid() == 1L;
    }

    private void testByMybatis() {
        String resource = "spring/mybatis-config.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();

            User user = session.selectOne("org.lwq.mybatissrcdemo.dao.UserMapper.queryUserInfoById", 1L);

            System.out.println(user);
            assert user.getUid() == 1L;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}