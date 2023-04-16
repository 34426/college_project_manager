package com.javanoteany.project.view;

import com.javanoteany.common.base.V;
import com.javanoteany.project.dto.Member;
import com.javanoteany.project.entity.Fund;
import com.javanoteany.user.view.UserView;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class ProjectView {

    //id
    @ApiModelProperty("id")
    @NotBlank(groups = {V.Update.class},message = "修改时id不能为空，请联系管理员!")
    private String id;

    //项目名
    @ApiModelProperty("项目名")
    @Size(min = 1,max = 30,groups = {V.Save.class,V.Update.class},message = "项目名[1-30]位!")
    @NotBlank(groups = {V.Save.class,V.Update.class},message = "项目名不能为空!")
    private String name;

    //项目级别
    @ApiModelProperty("项目级别")
    @NotBlank(groups = {V.Save.class,V.Update.class},message = "项目级别不能为空!")
    private String level;

    //负责人
    @ApiModelProperty("负责人")
    @Size(min = 2,max = 10,groups = {V.Save.class,V.Update.class,UserView.Login.class},message = "负责人[2-10]位!")
    @NotBlank(groups = {V.Save.class,V.Update.class,UserView.Login.class},message = "负责人不能为空!")
    private String userName;

    //成员
    @ApiModelProperty("成员")
    private List<Member> members;

    //项目结果类型
    @ApiModelProperty("项目结果类型")
    @NotBlank(groups = {V.Save.class,V.Update.class},message = "项目结果类型不能为空!")
    private String achievementType;

    //开始时间
    @ApiModelProperty("开始时间")
    private Date beginTime;

    //学科
    @ApiModelProperty("学科")
    @Size(min = 1,max = 10,groups = {V.Save.class,V.Update.class},message = "学科[5-10]位!")
    @NotBlank(groups = {V.Save.class,V.Update.class},message = "学科不能为空!")
    private String subject;

    //预期结果
    @ApiModelProperty("预期结果")
    @Size(min = 2,max = 200,groups = {V.Save.class,V.Update.class},message = "预期结果[2-200]位!")
    @NotBlank(groups = {V.Save.class,V.Update.class},message = "用户名不能为空!")
    private String expectedResult;

    //立项目的
    @ApiModelProperty("立项目的")
    @Size(min = 2,max = 200,groups = {V.Save.class,V.Update.class},message = "立项目的[2-200]位!")
    @NotBlank(groups = {V.Save.class,V.Update.class},message = "立项目的不能为空!")
    private String purpose;

    //资金
    @ApiModelProperty("资金")
    private List<Fund> funds;

    //研究方案可行性分析
    @ApiModelProperty("研究方案可行性分析")
    @Size(min = 2,max = 200,groups = {V.Save.class,V.Update.class},message = "研究方案可行性分析[2-200]位!")
    @NotBlank(groups = {V.Save.class,V.Update.class},message = "研究方案可行性分析不能为空!")
    private String viableAnalysis;

    //社会效益经济效益分析
    @ApiModelProperty("社会效益分析")
    @Size(min = 2,max =200,groups = {V.Save.class,V.Update.class},message = "社会效益分析[2-200]位!")
    @NotBlank(groups = {V.Save.class,V.Update.class},message = "社会效益分析不能为空!")
    private String economicAnalysis;

    //现有条件
    @ApiModelProperty("现有条件")
    @Size(min = 2,max = 200,groups = {V.Save.class,V.Update.class},message = "现有条件[2-200]位!")
    @NotBlank(groups = {V.Save.class,V.Update.class},message = "现有条件不能为空!")
    private String existingConditions;

    //所属学院
    @ApiModelProperty("所属学院")
    @NotBlank(groups = {V.Save.class,V.Update.class},message = "所属学院不能为空!")
    private String college;

    //项目状态
    @ApiModelProperty("项目状态")
    private int status;
    private String statusString;


    //是否可以修改
    @ApiModelProperty("是否可以修改")
    private boolean canUpdate;

    //是否可以申报
    @ApiModelProperty("是否可以申报")
    private boolean canApplication;

    //是否可以结题
    @ApiModelProperty("是否可以结题")
    private boolean canConclude;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusString() {
        return statusString;
    }

    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }


    public List<Fund> getFunds() {
        return funds;
    }

    public void setFunds(List<Fund> funds) {
        this.funds = funds;
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

    public boolean isCanUpdate() {

        return canUpdate;
    }

    public void setCanUpdate(boolean canUpdate) {
        this.canUpdate = canUpdate;
    }
}
