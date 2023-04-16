package com.javanoteany.user.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Set;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@ApiModel("分配角色视图")
public class AssignmentRoleView {

    @ApiModelProperty("角色")
    private List<RoleView> roles;

    @ApiModelProperty("用户的角色")
    private Set<String> userRoleIds;

    public AssignmentRoleView(List<RoleView> roles, Set<String> userRoleIds) {
        this.roles = roles;
        this.userRoleIds = userRoleIds;
    }

    public List<RoleView> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleView> roles) {
        this.roles = roles;
    }

    public Set<String> getUserRoleIds() {
        return userRoleIds;
    }

    public void setUserRoleIds(Set<String> userRoleIds) {
        this.userRoleIds = userRoleIds;
    }
}
