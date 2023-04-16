package com.javanoteany.common.exception;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class NotFoundException extends RuntimeException{
    public NotFoundException(String msg){
        super(msg);
    }
}
