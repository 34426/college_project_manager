package com.javanoteany.user.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class SecurityUserDto implements Serializable{
    //id
    private String id;

    //用户名
    private String userName;

    //真实姓名
    private String realName;

    //电话
    private String phone;

    //用户状态
    private String status;

    //用户类型
    private String type;

    //创建时间
    private Date createTime;

    //性别
    private String sex;

    //民族
    private String nation;

    //生日
    private Date birthday;

    //学位
    private String degree;

    //行政职务
    private String administrativeFunction;

    //专业职务
    private String professionalFunction;

    //研究专长
    private String specialization;

    //邮箱
    private String email;

    //简历
    private String resume;

    public SecurityUserDto() {
    }

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
