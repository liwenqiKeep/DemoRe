package org.lwq.annotation;

import java.lang.annotation.*;

/**
 * @author Liwq
 */
// 标识注解的存在方式，保存在代码中，类文件或者运行时，详见 RetentionPolicy
@Retention(RetentionPolicy.RUNTIME)
// 标识注解是否包含在用户文档中，这个注解只能存在在 其他注解上
@Documented
// 标识注解的作用范围
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})

// 标识注解可以被子类获取
@Inherited
// 标识可以重复注解
@Repeatable(AnnotationA.class)
public @interface MetaData {

}
