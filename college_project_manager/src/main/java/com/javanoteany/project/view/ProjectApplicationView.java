package com.javanoteany.project.view;

import com.javanoteany.common.base.V;
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
public class ProjectApplicationView {

    //申请通过
    public interface ApplicationPass{};

    //申请未通过
    public interface ApplicationNotPass{};

    //id
    @ApiModelProperty("id")
    @NotBlank(groups = {ConcludeApplicationView.ApplicationPass.class,ConcludeApplicationView.ApplicationNotPass.class},message ="id不能为空!")
    private String id;

    //项目id
    @ApiModelProperty("项目id")
    @NotBlank(groups = {V.Save.class,ConcludeApplicationView.ApplicationPass.class,ConcludeApplicationView.ApplicationNotPass.class},message = "项目id不能为空!")
    private String projectId;

    //项目名称
    @ApiModelProperty("项目名称")
    @Size(min = 1,max = 30,groups = {V.Save.class,ConcludeApplicationView.ApplicationPass.class,ConcludeApplicationView.ApplicationNotPass.class},message = "项目名称[1-30]位!")
    @NotBlank(groups = {V.Save.class,ConcludeApplicationView.ApplicationPass.class,ConcludeApplicationView.ApplicationNotPass.class},message = "项目名称不能为空!")
    private String projectName;

    //申请人
    @ApiModelProperty("申请人")
    private String applicant;

    //状态
    @ApiModelProperty("状态")
    private String status;

    //项目说明
    @ApiModelProperty("项目说明")
    @Size(min = 1,max = 200,groups = {V.Save.class},message = "项目说明[1-200]位!")
    @NotBlank(groups = {V.Save.class},message = "项目说明不能为空!")
    private String projectDescription;

    //反馈消息
    @ApiModelProperty("反馈消息")
    @Size(min = 1,max = 200,groups = {ConcludeApplicationView.ApplicationNotPass.class},message = "反馈消息[1-200]位!")
    @NotBlank(groups = {ConcludeApplicationView.ApplicationNotPass.class},message = "反馈消息不能为空!")
    private String backInformation;


    //申请时间
    @ApiModelProperty("申请时间")
    private Date applicateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getBackInformation() {
        return backInformation;
    }

    public void setBackInformation(String backInformation) {
        this.backInformation = backInformation;
    }

    public Date getApplicateTime() {
        return applicateTime;
    }

    public void setApplicateTime(Date applicateTime) {
        this.applicateTime = applicateTime;
    }
}
