package com.javanoteany.project.entity;

import com.javanoteany.common.base.entity.BaseEntity;
import com.javanoteany.common.utils.CurrentUserUtils;
import com.javanoteany.project.constant.ApplicationStatus;

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
@Table(name = BaseEntity.TABLE_PREFIX + "UPDATE_APPLICATION")
public class UpdateApplication extends BaseEntity{
    //项目id
    @Column(name = "project_id",nullable = false)
    private String projectId;

    //项目名称
    @Column(name = "project_name",nullable = false)
    private String projectName;

    //申请人
    @Column(name = "applicant",nullable = false)
    private String applicant;

    //状态
    @Column(name = "status",nullable = false)
    private String status;

    //变更说明
    @Column(name = "update_description")
    private String updateDescription;

    //反馈消息
    @Column(name = "back_information")
    private String backInformation;

    //申请时间
    @Column(name = "applicate_time",nullable = false)
    private Date applicateTime;

    //初始化
    public void init(){
        this.applicateTime = new Date();
        this.status = ApplicationStatus.ON_APPLIACTION.getName();
        this.applicant = CurrentUserUtils.getCurrentUser().getSecurityUserDto().getUserName();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdateDescription() {
        return updateDescription;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    public String getBackInformation() {
        return backInformation;
    }

    public void setBackInformation(String backInformation) {
        this.backInformation = backInformation;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Date getApplicateTime() {
        return applicateTime;
    }

    public void setApplicateTime(Date applicateTime) {
        this.applicateTime = applicateTime;
    }
}
