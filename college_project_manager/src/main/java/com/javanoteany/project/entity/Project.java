package com.javanoteany.project.entity;

import com.javanoteany.common.base.entity.BaseEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@Entity
@Table(name = BaseEntity.TABLE_PREFIX + "PROJECT")
public class Project extends BaseEntity{
    //项目名
    @Column(name = "name",nullable = false)
    private String name;

    //项目级别
    @Column(name = "level",nullable = false)
    private String level;

    //负责人
    @Column(name = "user_name",nullable = false)
    private String userName;

    //成员
    @Column(name = "memberJsons",nullable = false)
    private String memberJsons;

    //资金
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Fund.class,mappedBy = "projectId")
    private List<Fund> funds;

    //项目结果类型
    @Column(name = "achievement_type",nullable = false)
    private String achievementType;

    //开始时间
    @Column(name = "begin_time",nullable = false)
    private Date beginTime;

    //学科
    @Column(name = "subject",nullable = false)
    private String subject;

    //预期结果
    @Column(name = "expected_result",nullable = false)
    private String expectedResult;

    //立项目的
    @Column(name = "purpose",nullable = false)
    private String purpose;

    //研究方案可行性分析
    @Column(name = "viable_analysis",nullable = false)
    private String viableAnalysis;

    //社会效益分析
    @Column(name = "economic_analysis",nullable = false)
    private String economicAnalysis;

    //现有条件
    @Column(name = "existing_conditions",nullable = false)
    private String existingConditions;

    //所属学院
    @Column(name = "college" , nullable = false)
    private String college;

    //项目状态
    @Column(name = "status",nullable = false)
    private int status;

    //是否可以修改
    @Column(name = "can_update" )
    private boolean canUpdate;

    //是否可以申报
    @Column(name = "can_application")
    private boolean canApplication;

    //是否可以结题
    @Column(name = "can_conclude")
    private boolean canConclude;

    //创建人
    @Column(name = "created_user",nullable = false)
    private String createdUser;

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAchievementType() {
        return achievementType;
    }

    public void setAchievementType(String achievementType) {
        this.achievementType = achievementType;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getViableAnalysis() {
        return viableAnalysis;
    }

    public void setViableAnalysis(String viableAnalysis) {
        this.viableAnalysis = viableAnalysis;
    }

    public String getEconomicAnalysis() {
        return economicAnalysis;
    }

    public void setEconomicAnalysis(String economicAnalysis) {
        this.economicAnalysis = economicAnalysis;
    }

    public String getExistingConditions() {
        return existingConditions;
    }

    public void setExistingConditions(String existingConditions) {
        this.existingConditions = existingConditions;
    }

    public String getMemberJsons() {
        return memberJsons;
    }

    public void setMemberJsons(String memberJsons) {
        this.memberJsons = memberJsons;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Fund> getFunds() {
        return funds;
    }

    public void setFunds(List<Fund> funds) {
        this.funds = funds;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public boolean isCanUpdate() {
        return canUpdate;
    }

    public void setCanUpdate(boolean canUpdate) {
        this.canUpdate = canUpdate;
    }

    public boolean isCanApplication() {
        return canApplication;
    }

    public void setCanApplication(boolean canApplication) {
        this.canApplication = canApplication;
    }

    public boolean isCanConclude() {
        return canConclude;
    }

    public void setCanConclude(boolean canConclude) {
        this.canConclude = canConclude;
    }

}
