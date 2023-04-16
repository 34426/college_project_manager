package com.javanoteany.common.query;

/**
 *连接逻辑
 */
public enum  Logic{
    and("and"),
    or("or");

    private String code;

    Logic(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}