package org.lwq.jpademo.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {
    @Bean
    @Scope(value = "prototype")
    public SingletonDemo singletonDemo(){
        return new SingletonDemo();
    }
}
