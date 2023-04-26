package org.lwq.annotation;

/**
 * --@Bean 使用demo
 * @author liwenqi
 */
public class SpringBeanAnnotation {

    public SpringBeanAnnotation(){
        System.out.println("constructor method");
    }
    private void init() {
        System.out.println("init method");
    }

    private void destroy() {
        System.out.println("destroy method");
    }
}



