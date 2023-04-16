package com.javanoteany.common.exception;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class CopyFailedException extends RuntimeException{
    public CopyFailedException(String msg){
        super("对象拷贝失败!" + msg);
    }
}
