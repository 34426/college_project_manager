package com.javanoteany.user.view;

import com.javanoteany.common.base.V;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@ApiModel("用户视图")
public class UserView {

    public interface Login{}

    public interface UpdateStatus {}

    public interface complete{}

    //id
    @ApiModelProperty("id")
    @NotBlank(groups = {complete.class},message = "id不能为空!")
    private String id;

    //用户名
    @ApiModelProperty("用户名")
    @Size(min = 5,max = 10,groups = {V.Save.class,complete.class,Login.class},message = "用户名[5-10]位!")
    @NotBlank(groups = {V.Save.class,complete.class,Login.class},message = "用户名不能为空!")
    private String userName;

    //密码
    @ApiModelProperty("密码")
    @Size(min = 5,max = 10,groups = {V.Save.class,Login.class},message = "密码[5-10]位!")
    @NotBlank(groups = {V.Save.class,Login.class},message = "密码不能为空!")
    private String password;

    //用户状态
    @ApiModelProperty("用户状态")
    @NotBlank(groups = {UpdateStatus.class},message = "请选择用户状态!")
    private String status;

    //用户类型
    //user是普通用户 admin 是超级管理员
    @ApiModelProperty("用户类型")
    private String type;

    //创建时间
    @ApiModelProperty("创建时间")
    private Date createTime;

    //真实姓名
    @ApiModelProperty("真实姓名")
    @NotBlank(groups = {complete.class},message = "请填写真实姓名!")
    private String realName;

    //电话
    @ApiModelProperty("电话")
    @NotBlank(groups = {complete.class},message = "请填写电话!")
    private String phone;

    //身份证
    @ApiModelProperty("身份证")
    @NotBlank(groups = {complete.class},message = "请填写身份证!")
    private String card;

    //性别
    @ApiModelProperty("性别")
    @NotBlank(groups = {complete.class},message = "请选择性别!")
    private String sex;

    //民族
    @ApiModelProperty("民族")
    @NotBlank(groups = {complete.class},message = "请填选择民族!")
    private String nation;

    //生日
    @ApiModelProperty("生日")
    @NotBlank(groups = {complete.class},message = "请填写生日!")
    private Date birthday;

    //学位
    @ApiModelProperty("学位")
    @NotBlank(groups = {complete.class},message = "请填写学位!")
    private String degree;

    //行政职务
    @ApiModelProperty("行政职务")
    @NotBlank(groups = {complete.class},message = "请填写行政职务!")
    private String administrativeFunction;

    //专业职务
    @ApiModelProperty("专业职务")
    @NotBlank(groups = {complete.class},message = "请填写专业职务!")
    private String professionalFunction;

    //研究专长
    @ApiModelProperty("研究专长")
    @NotBlank(groups = {complete.class},message = "请填写研究专长!")
    private String specialization;

    //邮箱
    @ApiModelProperty("邮箱")
    @NotBlank(groups = {complete.class},message = "请填写邮箱!")
    private String email;

    //简历
    @ApiModelProperty("简历")
    @NotBlank(groups = {complete.class},message = "请填写简历!")
    private String resume;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getAdministrativeFunction() {
        return administrativeFunction;
    }

    public void setAdministrativeFunction(String administrativeFunction) {
        this.administrativeFunction = administrativeFunction;
    }

    public String getProfessionalFunction() {
        return professionalFunction;
    }

    public void setProfessionalFunction(String professionalFunction) {
        this.professionalFunction = professionalFunction;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}
