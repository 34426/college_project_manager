package com.javanoteany.common.exception;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.javanoteany.common.context.ContextUtils;
import com.javanoteany.common.exception.Handler.ExceptionHandler;
import com.javanoteany.common.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@Component
public class ExceptionHandlerInterceptor implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerInterceptor.class);


    private List<ExceptionHandler> exceptionHandlers = new ArrayList<>();

    public void init(){
        String[] exceptionHandler = ContextUtils.getApplicationContext().getBeanNamesForType(ExceptionHandler.class);
        for (String exception : exceptionHandler) {
            exceptionHandlers.add(ContextUtils.getApplicationContext().getBean(exception,ExceptionHandler.class));
        }
    }

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        if(exceptionHandlers.size() == 0){
            init();
        }

        ModelAndView mv = new ModelAndView();
        /*  使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常   */
        FastJsonJsonView view = new FastJsonJsonView();

        Object result = null;
        for (ExceptionHandler exceptionHandler : exceptionHandlers) {
            result = exceptionHandler.handler(response,ex);
            if(result != null){
                break;
            }
        }

        if(result ==  null){
            result = Result.getError(ex.getMessage());
        }

        //打印错误信息
        ex.printStackTrace();

        JSONObject object = (JSONObject) JSON.toJSON(result);
        view.setAttributesMap(object);
        mv.setView(view);
        return mv;
    }
}
