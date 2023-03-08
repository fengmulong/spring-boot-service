package com.lyd.config.annotation;

import java.lang.annotation.*;

/**
 * @author liyudong
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface WebLog {
   /* String description() default "";*/
    String messageDes() default  "";
}
