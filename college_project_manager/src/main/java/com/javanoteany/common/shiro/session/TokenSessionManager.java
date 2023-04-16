package com.javanoteany.common.shiro.session;

import com.javanoteany.common.constant.ShiroConstant;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.util.StringUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class TokenSessionManager extends DefaultWebSessionManager {

    protected Serializable getSessionId(ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rep = (HttpServletResponse) servletResponse;
        String token = null;
        //用户登录
        token = rep.getHeader(ShiroConstant.SESSION_TOKEN_KEY);
        if(StringUtils.isEmpty(token)){
            Cookie cookie = WebUtils.getCookie(req, ShiroConstant.SESSION_TOKEN_KEY);
            if(cookie != null){
                token = cookie.getValue();
            }else{
                token = req.getParameter( ShiroConstant.SESSION_TOKEN_KEY);
            }
        }
        return token;
    }
}
