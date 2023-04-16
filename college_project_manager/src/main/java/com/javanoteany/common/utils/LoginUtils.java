package com.javanoteany.common.utils;

import com.javanoteany.common.result.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class LoginUtils {

    /**
     * 用户登录
     * @param name 账号
     * @param password 密码
     * @return
     */
    public static Result login(String name, String password){
        try{
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(name,password));
        }catch (UnknownAccountException e) {
            return Result.getError("账号不存在!");
        }catch (IncorrectCredentialsException e) {
            return Result.getError("密码错误!");
        }catch (LockedAccountException e) {
            return Result.getError("账号已经被禁用,请联系管理员!");
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return Result.getSuccess();
    }

}
