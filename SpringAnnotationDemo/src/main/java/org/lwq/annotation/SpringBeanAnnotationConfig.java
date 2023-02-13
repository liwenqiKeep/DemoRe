package org.lwq.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liwenqi
 */
@Configuration
public class SpringBeanAnnotationConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public SpringBeanAnnotation myBean(){
        return new SpringBeanAnnotation();
    }

}
