package com.javanoteany.user.view;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class PasswordView {

    public interface UpdatePassword {}

    public interface UpdateCurrentUserPassword {}

    public interface ForgetPassword {}

    @ApiModelProperty("用户名")
    @Size(min = 5,max = 20,groups = {UpdatePassword.class,ForgetPassword.class},message = "用户名[5-20]位!")
    @NotBlank(groups = {UpdatePassword.class,ForgetPassword.class},message = "用户名不能为空!")
    private String userName;

    @ApiModelProperty("旧密码")
    @Size(min = 5,max = 20,groups = {UpdateCurrentUserPassword.class},message = "密码[5-20]位!")
    @NotBlank(groups = {UpdateCurrentUserPassword.class},message = "旧密码不能为空!")
    private String oldPassword;

    @ApiModelProperty("新密码")
    @Size(min = 5,max = 20,groups = {UpdatePassword.class,ForgetPassword.class,UpdateCurrentUserPassword.class},message = "密码[5-20]位!")
    @NotBlank(groups = {UpdatePassword.class,ForgetPassword.class,UpdateCurrentUserPassword.class},message = "密码不能为空!")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
