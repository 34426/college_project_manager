package com.javanoteany.common.aop;

import java.lang.annotation.*;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description AutoErrorhandler
 * @Version 1.0
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoErrorhandler {

}
