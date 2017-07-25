package com.liu.CatchYou.common.Basic.annotation;

import java.lang.annotation.*;

/**
 * Created by simon.liu on 2017/7/25.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Description {
    String value() default "";
}
