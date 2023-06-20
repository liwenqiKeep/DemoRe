package org.lwq.annotation;

import java.lang.annotation.*;

/**
 * @author Liwq
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AnnotationA {
    MetaData[] value();
}
