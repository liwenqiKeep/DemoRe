package org.lwq.jpademo.entity;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lwq.jpademo.component.BeanConfig;
import org.lwq.jpademo.component.SingletonDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountSecureTest  {
//    @Autowired
//    SingletonDemo singletonDemo;
//
//    @Autowired
//    ApplicationContext applicationContext;

    @Test
    public void testGetSlot() throws Exception {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);

        CountDownLatch countDownLatch = new CountDownLatch(1000);

        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100, 1000, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        int n = 1000;
        List<SingletonDemo> suitFilterRowKeys = new CopyOnWriteArrayList<>();
        for (int i = 0; i < n; i++) {
            threadPoolExecutor.execute(new Thread(() -> {
                SingletonDemo singletonDemo = ac.getBean(SingletonDemo.class);
//                singletonDemo.isExe();
                suitFilterRowKeys.add(singletonDemo);
                countDownLatch.countDown();
            }));
        }
        countDownLatch.await();

        System.out.println(suitFilterRowKeys.size());
    }
}