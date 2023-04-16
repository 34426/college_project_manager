package com.javanoteany.user.entity;

import com.javanoteany.common.base.entity.BaseEntity;
import com.javanoteany.common.constant.UserType;
import com.javanoteany.common.exception.CopyFailedException;
import com.javanoteany.common.utils.BeanCopyUtils;
import com.javanoteany.user.dto.SecurityUserDto;
import com.javanoteany.user.view.UserView;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@Entity
@Table(name = BaseEntity.TABLE_PREFIX + "USER")
public class User extends BaseEntity{

    //用户名
    @Column(name = "name",length = 50,nullable = false,unique = true)
    private String userName;

    //密码
    @Column(name = "password",length = 100,nullable = false)
    private String password;

    //用户状态
    //status是oracle关键词
    @Column(name = "state",nullable = false)
    private String status;

    //加盐
    @Column(name = "salt",nullable = false)
    private String salt;

    //用户类型
    //user是普通用户 admin 是超级管理员
    @Column(name = "type",nullable = false)
    private String type;

    //创建时间
    @Column(name = "create_time",nullable = false)
    private Date createTime;

    /**
     * 下面这些属性是否需要提取出去  做一个 一对一的关联 ？
     */
    //真实姓名
    @Column(name = "realname",length = 50)
    private String realName;

    //电话
    @Column(name = "phone",length = 11)
    private String phone;

    //身份证
    @Column(name = "card",length = 18)
    private String card;

    //所属学院
    @Column(name = "college")
    private String college;

    //性别
    @Column(name = "sex")
    private String sex;

    //民族
    @Column(name = "nation")
    private String nation;

    //生日
    @Column(name = "birthday")
    private Date birthday;

    //学位
    @Column(name = "degree")
    private String degree;

    //行政职务
    @Column(name = "administrative_function")
    private String administrativeFunction;

    //专业职务
    @Column(name = "professional_function")
    private String professionalFunction;

    //研究专长
    @Column(name = "specialization")
    private String specialization;

    //邮箱
    @Column(name = "email")
    private String email;

    //简历
    @Column(name = "resume")
    private String resume;

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    public SecurityUserDto toSecurityUserDto(User user){
        SecurityUserDto userDto ;
        try {
            userDto = BeanCopyUtils.copy(user,SecurityUserDto.class);
        } catch (Exception e) {
            throw new CopyFailedException(e.getMessage());
        }
        return userDto;
    }

    public UserView toUserView(User user){
        UserView userView ;
        try {
            userView = BeanCopyUtils.copy(user,UserView.class);
            userView.getType();
            UserType.valueOf("admin");
        } catch (Exception e) {
            throw new CopyFailedException(e.getMessage());
        }
        return userView;
    }
}
