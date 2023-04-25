package org.lwq.mybatissrcdemo.dao;

import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.lwq.mybatissrcdemo.entity.User;

import java.io.Reader;

public class UserMapperTest extends TestCase {

    public void testQueryUserInfoById() {
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