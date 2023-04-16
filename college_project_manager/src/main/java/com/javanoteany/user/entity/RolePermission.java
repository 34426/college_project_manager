package com.javanoteany.user.entity;

import com.javanoteany.common.base.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@Entity
@Table(name = BaseEntity.TABLE_PREFIX + "ROLE_PERMISSION")
public class RolePermission extends BaseEntity {

    @Column(nullable = false)
    private String roleId;

    @Column(nullable = false)
    private String permissionId;

    public RolePermission() {
    }

    public RolePermission(String roleId, String permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}
