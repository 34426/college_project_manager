package com.javanoteany.common.context;


import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class ContextData {

    private HttpServletRequest request;

    private HttpServletResponse response;

    private WebApplicationContext applicationConext;

    private Map<String,Object> data = new HashMap<>();


    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public WebApplicationContext getApplicationConext() {
        return applicationConext;
    }

    public void setApplicationConext(WebApplicationContext applicationConext) {
        this.applicationConext = applicationConext;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
