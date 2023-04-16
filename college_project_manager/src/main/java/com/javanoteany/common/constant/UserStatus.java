package com.javanoteany.common.constant;


/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public enum UserStatus {
    //用户被禁用
    LOCK("0","禁用"),
    //用户启用
    UNLOCK("1","启用");

    private String name;

    private String code;

    UserStatus(String code, String name) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
