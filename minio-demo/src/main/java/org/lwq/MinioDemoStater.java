package org.lwq;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * Hello world!
 *
 * @author liwenqi
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class},
        scanBasePackages = {"org.lwq"})
public class MinioDemoStater {
    public static void main(String[] args) {
        SpringApplication.run(MinioDemoStater.class, args);
    }
}
