package com.javanoteany.common.exception.Handler;

import javax.servlet.http.HttpServletResponse;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public interface ExceptionHandler {

    public Object handler(HttpServletResponse response, Throwable e);


}
