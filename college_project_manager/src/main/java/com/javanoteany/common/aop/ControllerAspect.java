package com.javanoteany.common.aop;

import com.javanoteany.common.exception.FieldErrorsException;
import com.javanoteany.common.result.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@Aspect
@Component
public class ControllerAspect {

    public static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    /**
     * Controller层切点
     */
    @Pointcut("@annotation(com.javanoteany.common.aop.AutoErrorhandler)")
    public  void controllerAspect() {

    }

    @Around("controllerAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Result result ;
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if(arg instanceof BindingResult){
                BindingResult bindingResult = (BindingResult) arg;
                if(bindingResult.hasErrors()){
                    throw new FieldErrorsException("字段验证错误！",bindingResult.getFieldErrors());
//                    return Result.getError("字段验证错误!" + bindingResult.getFieldErrors().get(0).getDefaultMessage());
                }
            }
        }
        try {
            logger.info("方法：" + joinPoint.getSignature() + "， 参数：" + joinPoint.getArgs());
            result = (Result) joinPoint.proceed();
        }catch (Throwable throwable){
            result = handlerException(joinPoint, throwable);
        }
        return result;
    }

    private Result handlerException(ProceedingJoinPoint joinPoint, Throwable e) {
        Result result = null;
        if (e instanceof RuntimeException) {
            logger.error("RuntimeException{方法：" + joinPoint.getSignature() + "， 参数：" + joinPoint.getArgs() + ",异常：" + e.getMessage() + "}", e);
            result = Result.getError(e.getMessage());
        } else {
            logger.error("异常{方法：" + joinPoint.getSignature() + "， 参数：" + joinPoint.getArgs() + ",异常：" + e.getMessage() + "}", e);
            result = Result.getError(e.getMessage());
        }
        return result;
    }
}
