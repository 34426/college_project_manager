package com.javanoteany.project.query;

import com.javanoteany.common.constant.UserType;
import com.javanoteany.common.query.Filter;
import com.javanoteany.common.query.Query;
import com.javanoteany.common.utils.CurrentUserUtils;
import org.springframework.util.StringUtils;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class ProjectQuery extends Query{

    //项目名
    private String name;

    //项目级别
    private String level;

    //负责人
    private String userName;

    //学科
    private String subject;

    //所属学院
    private String college;

    //项目状态
    private String status;

    //成果类型
    private String achievementType;

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getStatus() {
        return status;
    }

    public String getAchievementType() {
        return achievementType;
    }

    public void setAchievementType(String achievementType) {
        this.achievementType = achievementType;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void generateCondition() {
        //项目名模糊查询
        if(!StringUtils.isEmpty(name)){
            addFilter(new Filter("name", Filter.Operator.like, "%"+name+"%"));
        }
        //项目等级查询
        if(!StringUtils.isEmpty(level)){
            addFilter(new Filter("level", Filter.Operator.eq, level));
        }
        //项目负责人模糊查询
        if(!StringUtils.isEmpty(userName)){
            addFilter(new Filter("userName", Filter.Operator.like, "%"+userName+"%"));
        }
        //项目学科查询
        if(!StringUtils.isEmpty(subject)){
            addFilter(new Filter("subject", Filter.Operator.eq, subject));
        }
        //项目学院查询
        if(!StringUtils.isEmpty(college)){
            addFilter(new Filter("college", Filter.Operator.eq, college));
        }
        //项目状态查询
        if(!StringUtils.isEmpty(status)){
            addFilter(new Filter("status", Filter.Operator.eq, status));
        }
        //成果类型查询
        if(!StringUtils.isEmpty(achievementType)){
            addFilter(new Filter("achievementType", Filter.Operator.eq, achievementType));
        }
        //如果不是超级管理员 就不能看见所有人的申请
        if(!UserType.isAdmin(CurrentUserUtils.getCurrentUser().getSecurityUserDto().getType())){
            addFilter(new Filter("createdUser", Filter.Operator.eq, CurrentUserUtils.getCurrentUser().getSecurityUserDto().getUserName()));
        }
        //默认不显示废弃的项目
        addFilter(new Filter("status", Filter.Operator.neq, -1));
    }
}
