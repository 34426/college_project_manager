package com.javanoteany.project.query;

import com.javanoteany.common.query.Filter;
import com.javanoteany.common.query.Query;
import com.javanoteany.common.utils.CurrentUserUtils;
import com.javanoteany.user.entity.Role;

import java.util.List;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class ApplicationQuery extends Query{
    @Override
    public void generateCondition() {
        //如果不是科研工作者 就不能看见所有人的申请(暂时这样)
        List<Role> roles = CurrentUserUtils.getCurrentUser().getRoles();
        if(!roles.isEmpty()){
            for(Role role :roles){
                if(!role.getName().equals("科研管理员")){
                    addFilter(new Filter("applicant", Filter.Operator.eq, CurrentUserUtils.getCurrentUser().getSecurityUserDto().getUserName()));
                }
            }
        }


    }
}
