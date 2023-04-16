package com.javanoteany.common.exception.Handler;

import com.javanoteany.common.result.Result;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;


/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@Component
public class UnauthorizedExceptionHandler implements ExceptionHandler {
    public Object handler(HttpServletResponse response, Throwable e) {
        if(e instanceof UnauthorizedException){
            return Result.getError("你没有权限访问此页面!");
        }else{
            return null;
        }
    }
}
