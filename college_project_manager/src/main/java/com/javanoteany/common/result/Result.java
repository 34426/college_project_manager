package com.javanoteany.common.result;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class Result implements Serializable {

    @ApiModelProperty("错误码用来代表一些比较特殊的错误")
    private Integer  code;

    @ApiModelProperty("消息")
    private String  msg;

    @ApiModelProperty("数据")
    private Object data;

    @ApiModelProperty("具体的错误信息")
    private List errors;

    private boolean success;

    public Result() {
    }

    private Result(Integer code, String msg, Object data, List errors,boolean success) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.errors = errors;
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static  Result getSuccess(){
        return new Result(null,null,null,null,true);
    }

    public static  Result getSuccess(Object data){
        return new Result(null,null,data,null,true);
    }

    public static Result getError(String msg){
        return new Result(null,msg,null,null,false);
    }

    public static Result getError(List errors){
        return new Result(null,null,null,errors,false);
    }

    public static Result getError(Integer code,String msg){
        return new Result(code,msg,null,null,false);
    }

    public static Result getError(Integer code,String msg,List<Object> errors){
        return new Result(code,msg,null,errors,false);
    }

    public static Result getInstance(Integer code, String msg, Object data, List errors,boolean success){
        return new Result(code,msg,data,errors,success);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List getErrors() {
        return errors;
    }

    public void setErrors(List errors) {
        this.errors = errors;
    }
}
